import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) throws IOException, ExecutionException {
		String domainsPath = "mediaDomains";
		UrlVerification verificationObject = new UrlVerification();
		verificationObject.loadDomains(domainsPath);
		
		int NUM_THREADS = Integer.parseInt(args[0]);
		// int NUM_THREADS = Runtime.getRuntime().availableProcessors();
		// System.out.println("Available Processors: " + NUM_THREADS);
		FileObserver fObserver = new FileObserver(NUM_THREADS);
		// "C:/Users/Nikhil/Desktop/urlExt/test/Tweets_0.txt","C:/Users/Nikhil/Desktop/urlExt/test/OUT.txt"
		fObserver.extractFile(args[1], args[2], verificationObject);
	}
}
