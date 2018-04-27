package backend.database.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import backend.database.enums.RewardCategoryType;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String phone;
    private String address;
    private String name;
    private RewardCategoryType reward;
    private ArrayList<Wish> requests; 
    private ArrayList<Wish> accomplishments; 
    private ArrayList<Wish> inProcess;
    private String email;
    
    public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RewardCategoryType getReward() {
		return reward;
	}
	public void setReward(RewardCategoryType reward) {
		this.reward = reward;
	}
	public ArrayList<Wish> getRequests() {
		return requests;
	}
	public void setRequests(ArrayList<Wish> requests) {
		this.requests = requests;
	}
	public ArrayList<Wish> getAccomplishments() {
		return accomplishments;
	}
	public void setAccomplishments(ArrayList<Wish> accomplishments) {
		this.accomplishments = accomplishments;
	}
	public ArrayList<Wish> getInProcess() {
		return inProcess;
	}
	public void setInProcess(ArrayList<Wish> inProcess) {
		this.inProcess = inProcess;
	}
    
    
    
}