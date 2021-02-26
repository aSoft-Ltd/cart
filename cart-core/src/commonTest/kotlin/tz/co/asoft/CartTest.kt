package tz.co.asoft

import cart.Cart
import cart.CartItem
import kotlin.test.Test

class CartTest {
    @Test
    fun should_have_a_sub_total_of_all_the_items() {
        val cart1 = Cart(
            CartItem(
                name = "R.B",
                quantity = 1,
                price = 2000,
                images = listOf(),
                discount = 0
            ),
            CartItem(
                name = "Soda",
                quantity = 1,
                price = 600,
                images = listOf(),
                discount = 0
            ),
            CartItem(
                name = "Banana",
                quantity = 2,
                price = 200,
                images = listOf(),
                discount = 0
            )
        )
        expect(cart1.total).toBe(3000)
    }

    @Test
    fun should_consider_item_discount() {
        val cart2 = Cart(
            CartItem(
                name = "R.B",
                quantity = 2,
                price = 2000,
                images = listOf(),
                discount = 200
            ),
            CartItem(
                name = "Soda",
                quantity = 1,
                price = 600,
                images = listOf(),
                discount = 0
            ),
            CartItem(
                name = "Banana",
                quantity = 2,
                price = 200,
                images = listOf(),
                discount = 0
            )
        )
        expect(cart2.total).toBe(4600)
    }
}