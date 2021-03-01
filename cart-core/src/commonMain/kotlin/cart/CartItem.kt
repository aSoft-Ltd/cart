package cart

import kotlinx.serialization.Serializable

@Serializable
data class CartItem(
    val uid: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val images: List<String>,
    val discount: Long
) {
    /**
     * Sum of price for all the quantities
     */
    val subTotal: Long get() = price * quantity

    /**
     * Sum of discount for all the quantities
     */
    val discountTotal: Long get() = discount * quantity

    /**
     * Total with discount taken into consideration
     */
    val grandTotal: Long get() = subTotal - discountTotal
}