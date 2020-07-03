package encode;

import java.util.List;
import java.util.stream.Collectors;

import reader.BlastaProtein;

public class Encoder {

	public List<EncodedProtein> encodeProteins(List<BlastaProtein> rawList) {
		return rawList.stream().map(raw -> {
			String chain = raw.getChain();
			int length = chain.length();
			String[] encodedChain = new String[length];
			for (int i=0;i<length;i++) 
				encodedChain[i]=EncodingMap.encodeAA(chain.charAt(i));
			return new EncodedProtein(raw.getId(),raw.getName(), raw.getScl(),encodedChain, chain.length());
		}).collect(Collectors.toList());	
	}
}
