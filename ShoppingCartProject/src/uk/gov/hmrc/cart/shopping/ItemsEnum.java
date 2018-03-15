package uk.gov.hmrc.cart.shopping;

import java.math.BigDecimal;
import java.util.HashSet;

public enum ItemsEnum {
	
	APPLE (1L, new BigDecimal(Double.toString(0.60))), 
	ORANGE (2L, new BigDecimal(Double.toString(0.25)));
	
	private Long id;
	private BigDecimal price;
	
	private ItemsEnum(Long id, BigDecimal price) {
		this.price = price;
		this.id = id;
		
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Long getId() {
		return id;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public static HashSet<Long> getAllItem() {
		HashSet<Long> ids = new HashSet<Long>();
		
		for (ItemsEnum c : ItemsEnum.values()) {
			ids.add(c.getId());
		}
		return ids;
	}

}
