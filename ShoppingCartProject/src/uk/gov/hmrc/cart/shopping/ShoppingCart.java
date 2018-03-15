package uk.gov.hmrc.cart.shopping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * HMRC Java Technical Test
 * 
 * @author Abdul Hafiz
 *
 */
public class ShoppingCart {

	List<Item> basket = new ArrayList<Item>();

	static Long generatedId = null;

	public void scanItem(Object userInputItem) {
		generatedId =+ 1L;
		String inputStr = String.valueOf(userInputItem);
		Long scannedItemCode = Long.parseLong(inputStr);
		
		if ( scannedItemCode != null && ItemsEnum.getAllItem().contains(scannedItemCode)) {
			if (scannedItemCode.longValue() == ItemsEnum.APPLE.getId().longValue()) {
				Item item = new Item(generatedId, "Apple", new BigDecimal(0.60), scannedItemCode);			
				
				basket.add(item);
				
			} else if (scannedItemCode == ItemsEnum.ORANGE.getId()) {
				Item item = new Item(generatedId, "Orange", new BigDecimal(0.25), scannedItemCode);				
						
				basket.add(item);
				
			}
		} else {
			System.out.println("This Item does not exist");
		}
	}

	
	public List<Item> getBasket() {
		return basket;
	}

	public void setBasket(List<Item> basket) {
		this.basket = basket;
	}
	

}
