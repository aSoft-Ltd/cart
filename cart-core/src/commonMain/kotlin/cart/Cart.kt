package cart

data class Cart(val items: List<CartItem>) {
    constructor(vararg items: CartItem) : this(items.toList())

    val total get() = items.map { it.total }.reduce { acc, l -> acc + l }
}