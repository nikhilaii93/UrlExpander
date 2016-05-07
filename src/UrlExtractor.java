import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlExtractor {
	static String regExp = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	static Pattern p = Pattern.compile(regExp);
	
	public static ArrayList<String> extractUrls(String line) {
		Matcher m = p.matcher(line);
		ArrayList<String> urls = new ArrayList<String>();
		while(m.find()) {
			urls.add(m.group());
		}
		return urls;
	}
}
