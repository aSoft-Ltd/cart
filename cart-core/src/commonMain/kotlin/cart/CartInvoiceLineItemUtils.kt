package cart

val Collection<CartInvoiceLineItem>.total get() = map { it.amount }.reduce { acc, l -> acc + l }