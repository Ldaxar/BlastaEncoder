package encode;

import java.util.HashMap;
import java.util.Map;

public class EncodingMap {
	private static final Map<Character, String> encodingMap = new HashMap<Character, String>(); ;
	static {
		encodingMap.put('A', "000000000000000000001");
		encodingMap.put('C', "000000000000000000010");
		encodingMap.put('D', "000000000000000000100");
		encodingMap.put('E', "000000000000000001000");
		encodingMap.put('F', "000000000000000010000");
		encodingMap.put('G', "000000000000000100000");
		encodingMap.put('H', "000000000000001000000");
		encodingMap.put('I', "000000000000010000000");
		encodingMap.put('K', "000000000000100000000");
		encodingMap.put('L', "000000000001000000000");
		encodingMap.put('M', "000000000010000000000");
		encodingMap.put('N', "000000000100000000000");
		encodingMap.put('P', "000000001000000000000");
		encodingMap.put('Q', "000000010000000000000");
		encodingMap.put('R', "000000100000000000000");
		encodingMap.put('S', "000001000000000000000");
		encodingMap.put('T', "000010000000000000000");
		encodingMap.put('V', "000100000000000000000");
		encodingMap.put('W', "001000000000000000000");
		encodingMap.put('Y', "010000000000000000000");
	}
	
	public static String encodeAA (Character aa) {
		String encoding = encodingMap.get(aa);
		return encoding != null ? encoding : "100000000000000000000" ;
	}
}
