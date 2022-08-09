package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(28, discountedPrice);
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {

        //given
        Meal meal = new Meal(10);
        Meal meal1 = meal;

        //then
        assertSame(meal, meal1);
    }

    @Test
    void referencesToTheDifferentObjectsShouldNotBeEqual() {

        //given
        Meal meal = new Meal(10);
        Meal meal1 = new Meal(20);

        //then
        assertNotSame(meal, meal1);
    }

    @Test
    void twoMealShouldBeEqualWhenPriceAndNameAreTheSame() {

        //given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(20, "Pizza");

        //then
        assertEquals(meal1, meal2, "Checking if two meals are equal");
    }

}