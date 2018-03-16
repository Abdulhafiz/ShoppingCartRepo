package uk.gov.hmrc.cart.shopping;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

/**
 * HMRC Java Technical Test
 * 
 * @author Abdul Hafiz
 *
 */

public class CartTests {

	private static final long ORANGE = 2L;
	private static final long APPLE = 1L;

	/*
	 * Apple 60p and Orange 25p per piece
	 */

	@Test
	public void testScanItem() {
		Cart classUnderTest = scanItem2Ap3Or();

		assertEquals(5, classUnderTest.getBasket().size());
	}

	@Test
	public void testScanRightItem() {

		Cart classUnderTest = new Cart();

		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);

		assertEquals(2, classUnderTest.getBasket().size());
	}

	@Test
	public void testScanWrongItemNum() {

		Cart classUnderTest = new Cart();

		classUnderTest.scanItem(4L);

		assertEquals(0, classUnderTest.getBasket().size());
	}

	@Test(expected = NumberFormatException.class)
	public void testScanInvalidItem() {

		Cart classUnderTest = new Cart();

		classUnderTest.scanItem("AZ12");
	}

	@Test
	public void testChechoutTotlBeforeOffer() {
		Cart classUnderTest = scanItem2Ap3Or();

		BigDecimal totalPrice = classUnderTest.chechout(classUnderTest.getBasket());

		assertTrue(new BigDecimal(1.95).setScale(2, RoundingMode.CEILING).compareTo(totalPrice) == 0);
	}
	
	@Test
	public void testApplyOfferOnApple() {
		Cart classUnderTest = new Cart();
		classUnderTest.scanItem(APPLE);
		classUnderTest.scanItem(ORANGE);

		classUnderTest.applyOffer(classUnderTest.getBasket(), OfferEnum.BUY_ONE_GET_ONE_FREE.getCode(), APPLE);
		assertEquals(OfferEnum.BUY_ONE_GET_ONE_FREE.getCode(), classUnderTest.getBasket().get(0).getOfferCode());
		assertNotEquals(OfferEnum.THRE_FOR_THE_PRICE_TWO.getCode(), classUnderTest.getBasket().get(1).getOfferCode());
	}

	private Cart scanItem2Ap3Or() {
		Cart classUnderTest = new Cart();
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(2L);
		return classUnderTest;
	}

	private Cart scanItem3Ap4Or() {
		Cart classUnderTest = new Cart();
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(2L);
		classUnderTest.scanItem(1L);
		classUnderTest.scanItem(2L);
		return classUnderTest;
	}

}
