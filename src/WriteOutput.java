import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteOutput {
	public static void writeFile(ArrayList<String> str, String file) {
		/*
		for (int i = 0; i < str.size(); i++) {
			System.out.println(str.get(i));
		}
		*/
		
		// Since file is to be appended several times we use this method
		try (FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			for (int i = 0; i < str.size(); i++) {
				out.println(str.get(i));
			}
		} catch (IOException e) {
			System.out.println("Error in Writing File");
		}
	}
}
