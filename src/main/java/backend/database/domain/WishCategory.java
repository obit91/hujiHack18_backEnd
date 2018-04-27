package backend.database.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import backend.database.enums.WishCategoryType;

@Entity
public class WishCategory {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private WishCategoryType wishCategoryType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WishCategoryType getWishCategoryType() {
		return wishCategoryType;
	}

	public void setWishCategoryType(WishCategoryType wishCategoryType) {
		this.wishCategoryType = wishCategoryType;
	}
	
	

}
