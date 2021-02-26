package tz.co.asoft

import cart.CartItem
import kotlin.test.Test

class CartItemTest {
    val item = CartItem(
        name = "Wali Maharage",
        quantity = 2,
        price = 2000,
        images = listOf(),
        discount = 0
    )

    @Test
    fun should_have_a_total() {
        val item1 = item
        expect(item1.total).toBe(4000)
    }

    @Test
    fun should_consider_discount_properly() {
        val item2 = item.copy(discount = 500)
        expect(item2.total).toBe(3000)
    }

    @Test
    fun should_consider_quantity_properly() {
        val item3 = item.copy(quantity = 5, discount = 200)
        expect(item3.total).toBe(9000)
    }
}