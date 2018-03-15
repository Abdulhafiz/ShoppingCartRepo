package uk.gov.hmrc.cart.shopping;

/**
 * HMRC Java Technical Test
 * @author Abdul Hafiz
 *
 */

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
	
	private Long itemId;	
	private String itemName;	
	private BigDecimal itemPrice;
	private Long itemCode;
	private Long offerCode;
	
	public Item(Long itemId, String itemName, BigDecimal itemPrice,Long itemCode) {
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

	public boolean equals(Object o){
	    if (o instanceof Item){
	    	Item temp = (Item)o;
	        if (this.itemName.equals(temp.getItemName()))
	            return true;
	    }
	    return false;
	}
	
	@Override
	public int hashCode(){
	    return Objects.hashCode(this.itemName);
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
