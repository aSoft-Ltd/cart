package cart

data class CartItem(
    val name: String,
    val price: Long,
    val quantity: Int,
    val images: List<String>,
    val discount: Long
) {
    val total get() = (price - discount) * quantity
}