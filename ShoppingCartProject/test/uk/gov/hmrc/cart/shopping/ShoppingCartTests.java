package uk.gov.hmrc.cart.shopping;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;


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
	
	@Test
	public void testChechout() {
		ShoppingCart classUnderTest = scanItem();

		BigDecimal totalPrice = classUnderTest.chechout(classUnderTest.getBasket());

		assertTrue(new BigDecimal(1.95).setScale(2, RoundingMode.CEILING).compareTo(totalPrice) == 0);
	}
	
	@Test
	public void testCheckOffer() {
		ShoppingCart classUnderTest = new ShoppingCart();
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);

		assertEquals(OfferEnum.BUY_ONE_GET_ONE_FREE.getCode(), classUnderTest.getBasket().get(0).getOfferCode());
		assertEquals(OfferEnum.THRE_FOR_THE_PRICE_TWO.getCode(), classUnderTest.getBasket().get(1).getOfferCode());
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
