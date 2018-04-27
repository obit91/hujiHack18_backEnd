package backend.database.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import backend.database.enums.RewardCategoryType;
import backend.database.enums.WishCategoryType;
import backend.database.enums.WishStatusType;

@Entity
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String wishTitle;
	private RewardCategoryType rewardCategoryType;
	private WishCategoryType wishCategoryType;
	private String wishDescription;
	private String rewardDescription;
	private String rewardTitle;
//	 private String author;
	private Long authorId;
	private WishStatusType wishStatusType;
//	private ArrayList<User> confirmed;
//	private ArrayList<User> applying;
	
	public Long getId() {
		return id;
	}
	public RewardCategoryType getRewardCategoryType() {
		return rewardCategoryType;
	}
	public void setRewardCategoryType(RewardCategoryType rewardCategoryType) {
		this.rewardCategoryType = rewardCategoryType;
	}
	public WishCategoryType getWishCategoryType() {
		return wishCategoryType;
	}
	public void setWishCategoryType(WishCategoryType wishCategoryType) {
		this.wishCategoryType = wishCategoryType;
	}
	public WishStatusType getWishStatusType() {
		return wishStatusType;
	}
	public void setWishStatusType(WishStatusType wishStatusType) {
		this.wishStatusType = wishStatusType;
	}
	public String getRewardTitle() {
		return rewardTitle;
	}
	public void setRewardTitle(String rewardTitle) {
		this.rewardTitle = rewardTitle;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWishTitle() {
		return wishTitle;
	}
	public void setWishTitle(String wishTitle) {
		this.wishTitle = wishTitle;
	}
	public String getWishDescription() {
		return wishDescription;
	}
	public void setWishDescription(String wishDescription) {
		this.wishDescription = wishDescription;
	}
	public String getRewardDescription() {
		return rewardDescription;
	}
	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	
}