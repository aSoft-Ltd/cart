package cart

import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val uid: String,
    val items: MutableList<CartItem>
) {
    constructor(uid: String, vararg items: CartItem) : this(uid, items.toMutableList())

    /**
     * Adds the [item] to the [Cart]
     * @return [CartItem] representation found in the cart
     */
    fun add(item: CartItem): CartItem {
        val it = items.find { it.uid == item.uid }
        return if (it == null) {
            val i = item.copy()
            items.add(i)
            i
        } else {
            val i = it.copy(quantity = it.quantity + item.quantity)
            items.remove(it)
            items.add(i)
            i
        }
    }

    /**
     * Removes the [item] or some [CartItem.quantity] from the [Cart] if it was currently present in the cart
     * @return [CartItem] representation found in the cart or null if the cart is left without the item
     */
    fun remove(item: CartItem): CartItem? {
        val i = items.find { it.uid == item.uid } ?: return null
        items.remove(i)
        if (i.quantity >= item.quantity) {
            val i = item.copy(quantity = i.quantity - item.quantity)
            items.add(i)
            return i
        }
        return null
    }

    /**
     * Totally [eliminate] the item with id [itemId] from the cart
     * @return [CartItem] that was eliminated from the [Cart] or null if item with
     * [itemId] was not found in the cart
     */
    fun eliminate(itemId: String): CartItem? {
        val item = items.find { it.uid == itemId } ?: return null
        items.remove(item)
        return item
    }

    val subTotal get() = items.sumOf { it.subTotal }
    val discountTotal get() = items.sumOf { it.discountTotal }
    val grandTotal get() = items.sumOf { it.grandTotal }
}