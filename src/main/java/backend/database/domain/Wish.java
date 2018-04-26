package backend.database.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Wish {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    private String title;
    private String reward; 
    private String description;
    private String author;
    private ArrayList<User> confirmed;
    private ArrayList<User> applying;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public ArrayList<User> getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(ArrayList<User> confirmed) {
		this.confirmed = confirmed;
	}
	public ArrayList<User> getApplying() {
		return applying;
	}
	public void setApplying(ArrayList<User> applying) {
		this.applying = applying;
	}
    
    
}
