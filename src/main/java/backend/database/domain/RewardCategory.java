package backend.database.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import backend.database.enums.RewardCategoryType;

@Entity
public class RewardCategory {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private RewardCategoryType rewardCategoryType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RewardCategoryType getRewardCategoryType() {
		return rewardCategoryType;
	}

	public void setRewardCategoryType(RewardCategoryType rewardCategoryType) {
		this.rewardCategoryType = rewardCategoryType;
	}
	
	
}
