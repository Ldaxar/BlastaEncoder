package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	public List<BlastaProtein> readBlastaFile (String path) {
		String line;
		BlastaProtein currentProt = new BlastaProtein();
		List<BlastaProtein> list = new ArrayList<BlastaProtein>();
		StringBuilder currentChain = new StringBuilder();
		boolean assembly = false;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				if (line.startsWith(">")) {
					if (assembly) {
						currentProt.setChain(currentChain.toString());
						currentChain = new StringBuilder();
						list.add(currentProt);
					}
					assembly = true;
					
					currentProt = new BlastaProtein(Integer.parseInt(split[0].substring(1)), split[1], split[2]);
					
				}
				else {
					currentChain.append(line.strip());
				}
			}
			currentProt.setChain(currentChain.toString());
			currentChain = new StringBuilder();
			list.add(currentProt);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
