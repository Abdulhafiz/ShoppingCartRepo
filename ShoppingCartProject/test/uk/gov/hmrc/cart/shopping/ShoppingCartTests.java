package uk.gov.hmrc.cart.shopping;

import static org.junit.Assert.*;


import org.junit.Test;

import uk.gov.hmrc.cart.shopping.ShoppingCart;

/**
 * HMRC Java Technical Test
 * 
 * @author Abdul Hafiz
 *
 */

public class ShoppingCartTests {

	/*
	 * Apple 60p and Orange 25p per piece
	 */

	@Test
	public void testScanItem() {
		ShoppingCart classUnderTest = scanItem();

		assertEquals(5, classUnderTest.getBasket().size());
	}

	private ShoppingCart scanItem() {
		ShoppingCart classUnderTest = new ShoppingCart();
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(2L);
		return classUnderTest;
	}

}
