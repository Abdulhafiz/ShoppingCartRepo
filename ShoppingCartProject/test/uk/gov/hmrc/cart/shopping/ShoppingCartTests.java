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
	
	@Test
	public void testScanRightItem() {

		ShoppingCart classUnderTest = new ShoppingCart();

		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);

		assertEquals(2, classUnderTest.getBasket().size());
	}
	
	@Test
	public void testScanWrongItemNum() {

		ShoppingCart classUnderTest = new ShoppingCart();

		classUnderTest.scanItem(4L);

		assertEquals(0, classUnderTest.getBasket().size());
	}
	
	@Test(expected = NumberFormatException.class)
	public void testScanInvalidItem() {

		ShoppingCart classUnderTest = new ShoppingCart();

		classUnderTest.scanItem("AZ12");
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
