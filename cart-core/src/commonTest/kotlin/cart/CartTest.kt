package cart

import tz.co.asoft.expect
import tz.co.asoft.toBe
import kotlin.test.Test

class CartTest {
    @Test
    fun should_have_a_sub_total_of_all_the_items() {
        val cart1 = Cart(
            uid = "cart-1",
            CartItem(
                uid = "item-1",
                name = "R.B",
                quantity = 1,
                price = 2000,
                images = listOf(),
                discount = 0
            ),
            CartItem(
                uid = "item-2",
                name = "Soda",
                quantity = 1,
                price = 600,
                images = listOf(),
                discount = 0
            ),
            CartItem(
                uid = "item-3",
                name = "Banana",
                quantity = 2,
                price = 200,
                images = listOf(),
                discount = 0
            )
        )
        expect(cart1.grandTotal).toBe(3000)
    }

    @Test
    fun should_consider_item_discount() {
        val cart2 = Cart(
            uid = "cart-2",
            CartItem(
                uid = "item-1",
                name = "R.B",
                quantity = 2,
                price = 2000,
                images = listOf(),
                discount = 200
            ),
            CartItem(
                uid = "item-2",
                name = "Soda",
                quantity = 1,
                price = 600,
                images = listOf(),
                discount = 0
            ),
            CartItem(
                uid = "item-3",
                name = "Banana",
                quantity = 2,
                price = 200,
                images = listOf(),
                discount = 0
            )
        )
        expect(cart2.grandTotal).toBe(4600)
    }

    @Test
    fun should_add_items_to_cart_properly() {
        val cart = Cart(uid = "4545")
        val item1 = CartItem(
            uid = "item-1",
            name = "Test Item",
            price = 1000,
            quantity = 1,
            images = listOf(),
            discount = 0
        )
        cart.add(item1)
        expect(cart.items.size).toBe(1)
        expect(cart.items[0].quantity).toBe(1)
        cart.add(item1)
        expect(cart.items.size).toBe(1)
        expect(cart.items[0].quantity).toBe(2)
        cart.add(item1)
        expect(cart.items.size).toBe(1)
        expect(cart.items[0].quantity).toBe(3)
        val item2 = item1.copy(uid = "item-1", quantity = 5)
        cart.add(item2)
        expect(cart.items.size).toBe(1)
        expect(cart.items[0].quantity).toBe(8)
        val item3 = item1.copy(
            uid = "item-3",
            quantity = 4
        )
        cart.add(item3)
        expect(cart.items.size).toBe(2)
        expect(cart.items[0].quantity).toBe(8)
        expect(cart.items[1].quantity).toBe(4)

        val item4 = item3.copy(uid = "item-4", quantity = 2)
        cart.add(item4)
        expect(cart.items.size).toBe(3)
        expect(cart.items[0].quantity).toBe(8)
        expect(cart.items[1].quantity).toBe(4)
        expect(cart.items[2].quantity).toBe(2)
    }

    @Test
    fun should_remove_items_from_the_cart() {
        val item1 = CartItem(
            uid = "item-1",
            name = "Test Item",
            price = 1000,
            quantity = 5,
            images = listOf(),
            discount = 0
        )
        val cart = Cart(
            uid = "cart-333",
            item1
        )
        expect(cart.items.size).toBe(1)
        expect(cart.grandTotal).toBe(5000)
        expect(cart.items[0].quantity).toBe(5)
        cart.remove(item1.copy(quantity = 2))
        expect(cart.items[0].quantity).toBe(3)
    }
}