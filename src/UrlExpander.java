import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class UrlExpander {
	public static String expandUrl(String shortenedUrl) throws IOException {
		URL url = new URL(shortenedUrl);
		// open connection
		// Proxy proxy = new Proxy(Proxy.Type.HTTPS, new
		// InetSocketAddress("https://proxy61.iitd.ac.in", 3128));
		Properties systemProperties = System.getProperties();
		systemProperties.setProperty("http.proxyHost", "proxy61.iitd.ac.in");
		systemProperties.setProperty("http.proxyPort", "3128");
		systemProperties.setProperty("https.proxyHost", "proxy61.iitd.ac.in");
		systemProperties.setProperty("https.proxyPort", "3128");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

		// stop following browser redirect
		httpURLConnection.setInstanceFollowRedirects(false);

		// extract location header containing the actual destination URL
		String expandedURL = httpURLConnection.getHeaderField("Location");
		httpURLConnection.disconnect();
		
		return expandedURL;
	}
}