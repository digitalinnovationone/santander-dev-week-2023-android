package dio.me.extensions

import java.text.NumberFormat
import java.util.Locale

fun Double.formatCurrency(locale: Locale = Locale.getDefault()): String {
    return NumberFormat.getCurrencyInstance(locale).format(this)
}
