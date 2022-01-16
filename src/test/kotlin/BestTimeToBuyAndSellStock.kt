import org.junit.Test
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStock {
    @Test
    fun testScenario() {
        assertEquals(5, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    fun maxProfit(prices: IntArray): Int {
        val minimumPrice = prices.minOrNull()

        val minIndex = prices.indexOfFirst { it == minimumPrice }
        val maxPrice = prices.slice(IntRange(minIndex, prices.count() - 1)).maxOrNull()

        if(maxPrice!! > minimumPrice!!) {
            return maxPrice - minimumPrice
        }
        return 0
    }
}