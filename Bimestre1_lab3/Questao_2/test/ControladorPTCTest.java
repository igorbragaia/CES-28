package Q4.ptc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class ControladorPTCTest {
	@Rule
    public ExpectedException expectedException = ExpectedException.none();
    private ControladorPTC controladorPTC;

    @Test
    public void testConstructor() {
        int actualPrice = pub.computeCost("hansa", false, 1);
        assertEquals(74, actualPrice);
    }

    @Test
    public void testStudentsGetADiscountForBeer() throws Exception {
        int actualPrice = pub.computeCost("hansa", true, 1);
        assertEquals(67, actualPrice);
    }

    @Test
    public void testCidersAreCostly() throws Exception {
        int actualPrice = pub.computeCost("grans", false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    public void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost("strongbow", false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    public void testACocktail() throws Exception {
        int actualPrice = pub.computeCost("gt", false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testThatADrinkNotInTheSortimentGivesError() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("No such drink");
        pub.computeCost("sanfranciscosling", false, 1);
    }

    @Test
    public void testStudentsDoNotGetDiscountsForCocktails() throws Exception {
        int actualPrice = pub.computeCost("gt", true, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost("bacardi_special", false, 1);
        assertEquals(170, actualPrice);
    }

    @Test
    public void testCanBuyAtMostTwoDrinksInOneGo() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Too many");
        pub.computeCost("bacardi_special", false, 3);
    }

    @Test
    public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() throws Exception {
        int actualPrice = pub.computeCost("hansa", true, 2);
        assertEquals(67*2, actualPrice);
    }

    @Test
    public void testCanOrderMoreThanTwoBeers() throws Exception {
        pub.computeCost("hansa", false, 5);
    }

    @Test
    public void testStudentsGetADiscountForBeer() throws Exception {
        int actualPrice = pub.computeCost("hansa", true, 1);
        assertEquals(67, actualPrice);
    }

    @Test
    public void testCidersAreCostly() throws Exception {
        int actualPrice = pub.computeCost("grans", false, 1);
        assertEquals(103, actualPrice);
    }

    @Test
    public void testProperCidersAreEvenMoreExpensive() throws Exception {
        int actualPrice = pub.computeCost("strongbow", false, 1);
        assertEquals(110, actualPrice);
    }

    @Test
    public void testACocktail() throws Exception {
        int actualPrice = pub.computeCost("gt", false, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testThatADrinkNotInTheSortimentGivesError() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("No such drink");
        pub.computeCost("sanfranciscosling", false, 1);
    }

    @Test
    public void testStudentsDoNotGetDiscountsForCocktails() throws Exception {
        int actualPrice = pub.computeCost("gt", true, 1);
        assertEquals(115, actualPrice);
    }

    @Test
    public void testBacardiSpecial() throws Exception {
        int actualPrice = pub.computeCost("bacardi_special", false, 1);
        assertEquals(170, actualPrice);
    }

    @Test
    public void testCanBuyAtMostTwoDrinksInOneGo() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Too many");
        pub.computeCost("bacardi_special", false, 3);
    }

    @Test
    public void testStudentsGetDiscountsWhenOrderingMoreThanOneBeer() throws Exception {
        int actualPrice = pub.computeCost("hansa", true, 2);
        assertEquals(67*2, actualPrice);
    }

    @Test
    public void testCanOrderMoreThanTwoBeers() throws Exception {
        pub.computeCost("hansa", false, 5);
    }
	
	

}