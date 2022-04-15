package com.connectYou.chat.DTO;
//like a model
public class userDTO {
	private String userId;
	private char password[];
	private String email;
	private String phoneNumber;
	private String city;
	
	
	
	
	

	

	public userDTO(String userId2, char[] password2,String email,String phoneNumber,String city) {
		this.userId=userId2;
		this.password=password2;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.city=city;
	}



	public userDTO(String userId2, char[] password2) {
		this.userId=userId2;
		this.password=password2;
	}




	



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	

}
