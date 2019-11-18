import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDateTime

class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {
        val map = mutableMapOf<DayOfWeek, Int>()
        for (order in orders) {
            val v = map.getOrDefault(order.creationDate.dayOfWeek, 0)
            map[order.creationDate.dayOfWeek] = v + order.orderLines.sumBy { it.quantity }
        }
        return map
    }
}