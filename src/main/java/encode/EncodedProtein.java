package encode;

public class EncodedProtein {
	private int id;
	private String name;
	private String scl;
	private String[] encodedChain;
	private int proteinLength;
	
	public EncodedProtein(int id, String name, String scl, String[] encodedChain, int proteinLength) {
		super();
		this.id = id;
		this.name = name;
		this.scl = scl.charAt(scl.length()-2)+"";
		this.encodedChain = encodedChain;
		this.proteinLength = proteinLength;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScl() {
		return scl;
	}
	public void setScl(String scl) {
		this.scl = scl;
	}
	public String[] getEncodedChain() {
		return encodedChain;
	}
	public void setEncodedChain(String[] encodedChain) {
		this.encodedChain = encodedChain;
	}
	public int getProteinLength() {
		return proteinLength;
	}
	public void setProteinLength(int proteinLength) {
		this.proteinLength = proteinLength;
	}

	
	
}
