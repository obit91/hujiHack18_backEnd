package backend.database.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import backend.database.enums.WishStatusType;

@Entity
public class WishStatus {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private WishStatusType wishStatusType;

	public WishStatusType getWishStatusType() {
		return wishStatusType;
	}

	public void setRewardType(WishStatusType wishStatusType) {
		this.wishStatusType = wishStatusType;
	}

	public Long getId() {
		return id;
	}

}
