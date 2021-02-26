package cart

/**
 * @param cart The cart itself
 * @param positiveLineItem Increase the total price of the cart (i.e. tax)
 * @param negativeLineItem Decrease the total price of the cart (i.e. discounts)
 */
data class CartInvoice(
    val cart: Cart,
    val positiveLineItem: List<CartInvoiceLineItem>,
    val negativeLineItem: List<CartInvoiceLineItem>
) {
    val subTotal get() = cart.total

    /**
     * Returns total amount of the [positiveLineItem]
     */
    val positives get() = positiveLineItem.total

    /**
     * Returns total amount of the [negativeLineItem]
     */
    val negatives get() = negativeLineItem.total

    val total get() = subTotal + positives - negatives
}