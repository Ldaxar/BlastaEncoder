package reader;

public class BlastaProtein {
	private int id;
	private String name;
	private String scl;
	private String chain;
	
	public BlastaProtein() {
		
	}

	
	
	public BlastaProtein(int id, String name, String scl) {
		super();
		this.id = id;
		this.name = name;
		this.scl = scl;
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
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}



	@Override
	public String toString() {
		return "BlastaProtein [id=" + id + ", name=" + name + ", scl=" + scl + ", chain=" + chain + "]";
	}
	
	
	
	
}
