import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UrlVerification {
	ArrayList<String> domains = new ArrayList<String>();
	
	public void loadDomains(String filePath) throws IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("mediaDomains file not found");
		}
		String str;
		while ((str = in.readLine()) != null) {
			domains.add(str.trim());
		}
		return;
	}
	
	// Returns matched domains as concatenated with +
	// In case of no match returns ""
	public String getMatch(ArrayList<String> urls) {
		String matched = "";
		
		for (int i = 0; i < urls.size(); i++) {
			for (int j = 0; j < domains.size(); j++) {
				if (urls.get(i).contains(domains.get(j))) {
					matched += domains.get(j) + "+";
					break;
				}
			}
		}
		return matched;
	}
}
