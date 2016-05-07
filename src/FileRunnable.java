import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FileRunnable implements Callable<ArrayList<String>> {
	private String line;

	public FileRunnable(String line) {
		this.line = line;
	}

	public ArrayList<String> call() {
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
				expandedUrls.add(urls.get(i) + " ---> " + expandedUrl);
				// System.out.println(urls.get(i) + " ---> " + expandedUrl);
			} catch (Exception e) {
				System.out.println("URL Error Occured: " + urls.get(i));
			}
		}
		
		if (line.equalsIgnoreCase("Exception"))
			throw new RuntimeException("File reading Exception");
		// log.debug(line);
		
		return expandedUrls;
	}
}
