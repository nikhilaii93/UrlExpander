import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) throws IOException, ExecutionException {
		// String shortenedUrl = "http://t.co/zXi0coN3G6";
		// String expandedURL = UrlExpander.expandUrl(shortenedUrl);

		// System.out.println(shortenedUrl + "-->" + expandedURL);
		// int NUM_THREADS = Runtime.getRuntime().availableProcessors();
		int NUM_THREADS = Integer.parseInt(args[0]);
		System.out.println("Available Processors: " + NUM_THREADS);
		FileObserver fObserver = new FileObserver(NUM_THREADS);
		// "C:/Users/Nikhil/Desktop/urlExt/test/Tweets_0.txt","C:/Users/Nikhil/Desktop/urlExt/test/OUT.txt"
		fObserver.extractFile(args[1], args[2]);
	}
}
