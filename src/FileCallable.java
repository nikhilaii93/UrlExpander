import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FileCallable implements Callable<String> {
	private String line;
	UrlVerification verificationObject;
	
	public FileCallable(String line, UrlVerification verificationObject) {
		this.line = line;
		this.verificationObject = verificationObject;
	}

	public String call() {
		// Handle record here to validate and store.
		ArrayList<String> urls = UrlExtractor.extractUrls(line);
		ArrayList<String> expandedUrls = new ArrayList<String>();
		for (int i = 0; i < urls.size(); i++) {
			try {
				String expandedUrl = UrlExpander.expandUrl(urls.get(i));
				// In case url is already expanded
				if (expandedUrl == null) {
					expandedUrl = urls.get(i);
				}
				expandedUrls.add(expandedUrl);
				// System.out.println(urls.get(i) + " ---> " + expandedUrl);
			} catch (Exception e) {
				System.out.println("URL Error Occured: " + urls.get(i));
			}
		}
		
		if (line.equalsIgnoreCase("Exception"))
			throw new RuntimeException("File reading Exception");
		// log.debug(line);
		String match = verificationObject.getMatch(expandedUrls);
		
		if (!match.equals("")) {
			return match+line;
		} else {
			return match;
		}
	}
}
