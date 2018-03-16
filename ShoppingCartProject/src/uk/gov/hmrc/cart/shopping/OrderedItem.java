package uk.gov.hmrc.cart.shopping;

/**
 * HMRC Java Technical Test
 * @author Abdul Hafiz
 *
 */

import java.math.BigDecimal;
import java.util.Objects;

public class OrderedItem {
	
	private Long itemId;	
	private String itemName;	
	private BigDecimal itemPrice;
	private Long itemCode;
	private Long offerCode;
	
	
	public OrderedItem (Long itemId, String itemName, BigDecimal itemPrice,Long itemCode) {
		this.itemId=itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;	
		this.itemCode = itemCode;	
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (this == obj)
			return true;
		else
			return this.hashCode() == ((OrderedItem) obj).hashCode();
	}

	@Override
	public int hashCode() {
		return this.itemCode.intValue();
	}

	public Long getItemCode() {
		return itemCode;
	}

	public void setItemCode(Long itemCode) {
		this.itemCode = itemCode;
	}
	
	public Long getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(Long offerCode) {
		this.offerCode = offerCode;
	}

	
}
