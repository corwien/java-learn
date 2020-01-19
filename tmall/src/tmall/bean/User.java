package tmall.bean;

public class User {
	private String password;
    private String name;
    private int id;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAnonymousName() {
		if(null == name)
			return null;
		
		if(name.length() <= 1)
			return "*";
		
		if(name.length() == 2)
			return name.substring(0,1) +"*";
		
		char[] cs = name.toCharArray();
		// System.out.println(cs);
		
		for(int i=1; i < cs.length-1; i++) {
			cs[i] = '*';
		}
		// System.out.println(cs);
		return new String(cs);
			
	}
	
	public static void main(String []args) {
		
		String test = "我们吃喝";
		User user = new User();
		user.name = test;
		String res = user.getAnonymousName();
		System.out.println(res);
		
	}
    
}
