package uk.gov.hmrc.cart.shopping;

import java.util.HashSet;

public enum OfferEnum {
	BUY_ONE_GET_ONE_FREE(101L), 
	THRE_FOR_THE_PRICE_TWO(202L);

	private Long offerCode;

	private OfferEnum(Long code) {
		this.offerCode = code;
	}

	public Long getCode() {
		return offerCode;
	}

	public void setCode(Long code) {
		this.offerCode = code;
	}
	
	public static HashSet<Long> getAllOffer() {
		HashSet<Long> offerItems = new HashSet<Long>();
		
		for (OfferEnum c : OfferEnum.values()) {
			offerItems.add(c.getCode());
		}
		return offerItems;
	}

}
