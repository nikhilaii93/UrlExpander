import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteOutput {
	public static void writeFile(String str, String file) {

		// Since file is to be appended several times we use this method
		try (FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(str);
		} catch (IOException e) {
			System.out.println("Error in Writing File");
		}
	}
}
