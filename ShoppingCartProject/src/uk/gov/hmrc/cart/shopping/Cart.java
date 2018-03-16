package uk.gov.hmrc.cart.shopping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * HMRC Java Technical Test
 * 
 * @author Abdul Hafiz
 *
 */
public class Cart {
	private final static Logger LOGGER = Logger.getLogger(Cart.class.getName());

	List<OrderedItem> basket = new ArrayList<OrderedItem>();

	static Long generatedId = null;

	public void scanItem(Object userInputItem) {
		generatedId = +1L;
		Long scannedItemCode = validItem(userInputItem);

		if (scannedItemCode != null && ItemsEnum.getAllItem().contains(scannedItemCode)) {
			if (scannedItemCode.longValue() == ItemsEnum.APPLE.getCode().longValue()) {
				OrderedItem item = new OrderedItem(generatedId, "Apple", new BigDecimal(0.60), scannedItemCode);

				basket.add(item);

			} else if (scannedItemCode == ItemsEnum.ORANGE.getCode()) {
				OrderedItem item = new OrderedItem(generatedId, "Orange", new BigDecimal(0.25), scannedItemCode);

				basket.add(item);

			}
		} else {
			LOGGER.info("This Item does not exist");
		}
	}

	private Long validItem(Object userItem) {
		Long itemLongValue = null;
		try {
			itemLongValue = castObjectToLong(userItem);
		} catch (NumberFormatException nfe) {
			LOGGER.warning("Invalid Item");
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

	public void applyOffer(List<OrderedItem> basket, Long offerCode, long itemCode) {

		for (OrderedItem item : basket) {
			if (item.getItemCode().longValue() == itemCode && ItemsEnum.APPLE.getCode() == itemCode
					&& OfferEnum.BUY_ONE_GET_ONE_FREE.getCode() == offerCode) {
				item.setOfferCode(OfferEnum.BUY_ONE_GET_ONE_FREE.getCode());
			}

			if (item.getItemCode().longValue() == itemCode && ItemsEnum.ORANGE.getCode() == itemCode
					&& OfferEnum.THRE_FOR_THE_PRICE_TWO.getCode() == offerCode) {
				item.setOfferCode(OfferEnum.THRE_FOR_THE_PRICE_TWO.getCode());
			}
		}
	}

	public List<OrderedItem> getBasket() {
		return basket;
	}

	public void setBasket(List<OrderedItem> basket) {
		this.basket = basket;
	}

}
