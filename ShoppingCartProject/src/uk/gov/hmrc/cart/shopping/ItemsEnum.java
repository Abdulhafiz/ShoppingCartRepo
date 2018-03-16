package uk.gov.hmrc.cart.shopping;

import java.math.BigDecimal;
import java.util.HashSet;

public enum ItemsEnum {
	
	APPLE (1L, new BigDecimal(Double.toString(0.60))), 
	ORANGE (2L, new BigDecimal(Double.toString(0.25)));
	
	private Long code;
	private BigDecimal price;
	
	private ItemsEnum(Long code, BigDecimal price) {
		this.price = price;
		this.code = code;
		
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Long getCode() {
		return code;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setCode(Long id) {
		this.code = id;
	}
	
	public static HashSet<Long> getAllItem() {
		HashSet<Long> ids = new HashSet<Long>();
		
		for (ItemsEnum c : ItemsEnum.values()) {
			ids.add(c.getCode());
		}
		return ids;
	}

}
