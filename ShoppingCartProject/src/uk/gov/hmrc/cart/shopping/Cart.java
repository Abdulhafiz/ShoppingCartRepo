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
public class Cart {

	List<OrderedItem> basket = new ArrayList<OrderedItem>();

	static Long generatedId = null;

	public void scanItem(Object userInputItem) {
		generatedId = +1L;
		Long scannedItemCode = validItem(userInputItem);

		if (scannedItemCode != null && ItemsEnum.getAllItem().contains(scannedItemCode)) {
			if (scannedItemCode.longValue() == ItemsEnum.APPLE.getId().longValue()) {
				OrderedItem item = new OrderedItem(generatedId, "Apple", new BigDecimal(0.60), scannedItemCode);
				if(checkOffer(ItemsEnum.APPLE)){
					item.setOfferCode(OfferEnum.BUY_ONE_GET_ONE_FREE.getCode());
				}
				basket.add(item);

			} else if (scannedItemCode == ItemsEnum.ORANGE.getId()) {
				OrderedItem item = new OrderedItem(generatedId, "Orange", new BigDecimal(0.25), scannedItemCode);
				if(checkOffer(ItemsEnum.ORANGE)){
					item.setOfferCode(OfferEnum.THRE_FOR_THE_PRICE_TWO.getCode());
				}
				basket.add(item);

			}
		} else {
			System.out.println("This Item does not exist");
		}
	}

	private Long validItem(Object userItem) {
		Long itemLongValue = null;
		try {
			itemLongValue = castObjectToLong(userItem);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Item");
			throw new NumberFormatException("This item id is not valid : " + nfe.getMessage());
		}
		return itemLongValue;
	}

	private Long castObjectToLong(Object object) {
		return Long.parseLong(object.toString());
	}

	public BigDecimal chechout(List<OrderedItem> itemList) {
		BigDecimal totalPrice = new BigDecimal(0);

		for (OrderedItem item : basket) {
			totalPrice = totalPrice.add(item.getItemPrice());
		}
		return totalPrice.setScale(2, RoundingMode.CEILING);
	}

	public boolean checkOffer(ItemsEnum dbItem) {

		return dbItem.getOfferCode() != null && dbItem.getOfferCode().longValue() > 0;

	}

	public List<OrderedItem> getBasket() {
		return basket;
	}

	public void setBasket(List<OrderedItem> basket) {
		this.basket = basket;
	}

}
