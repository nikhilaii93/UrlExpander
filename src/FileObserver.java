import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class to extract file and to dispatching every line to sub task. Sub task
 * which in turns validate / persists records in parallel.
 */
public class FileObserver {

	// private static Logger log = Logger.getLogger(FileObserver.class);
	// private int numberOfThread;
	private ExecutorService pool;
	private CompletionService<ArrayList<String>> completionService;

	/**
	 * Constructor to accept thread for ThreadPool
	 * 
	 * @param numberOfThread
	 */
	public FileObserver(int numberOfThread) {
		// this.numberOfThread = numberOfThread;
		this.pool = Executors.newScheduledThreadPool(numberOfThread);
		completionService = new ExecutorCompletionService<ArrayList<String>>(pool);
	}

	/**
	 * Method to extract file line by line and to fill sub task queue.
	 * @throws ExecutionException 
	 */
	public void extractFile(String fileName, String outFile) throws ExecutionException {
		BufferedReader in = null;
		ArrayList<Future<ArrayList<String>>> futures = new ArrayList<Future<ArrayList<String>>>();
		try {
			in = new BufferedReader(new FileReader(fileName));
			String str;
			int readLineCount = 0;
			while ((str = in.readLine()) != null) {
				readLineCount++;
				futures.add(completionService.submit(new FileRunnable(str)));
				if (readLineCount%100 == 0) {
					System.out.println("ReadLineCount: " + readLineCount);
				}
			}
			
			int writtenLineCount = 0;
			for (int i = 0; i < futures.size(); i++) {
				Future<ArrayList<String>> next;
				try {
					next = completionService.take();
					ArrayList<String> textUrls = next.get();
					int a = writtenLineCount/100;
					writtenLineCount += textUrls.size();
					int b = writtenLineCount/100;
					if (b == a+1) {
						System.out.println ("WrittenLineCount: " + writtenLineCount);
					}
					WriteOutput.writeFile(textUrls, outFile);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			in.close();
			pool.shutdownNow();
		} catch (IOException e) {
			// log.error(e.getMessage(),e);
			try {
				in.close();
			} catch (IOException e1) {
				// log.error(e1.getMessage(),e1); }
				pool.shutdownNow();

			}
		}
	}
}
