package maven.demo;

public class users {
	private int code;
	private String login;
	private String pass;
	private char gender;
	
	public users() {}
	
	public users(int code, String login, String pass, char gender) {
		this.code = code;
		this.login = login;
		this.pass = pass;
		this.gender = gender;
	}
	
	public int getCode() {return code;}
	public void setCode(int code) {this.code = code;}
	
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	
	public String getPass() {return pass;}
	public void setPass(String pass) {this.pass = pass;}
	
	public char getGender() {return gender;}
	public void setGender(char gender) {this.gender = gender;}
	
	public String toString() {
		return "[code=" + code + ". login=" + login + ", pass=" + pass + ", gender=" + gender + "]";
	}
	
}
