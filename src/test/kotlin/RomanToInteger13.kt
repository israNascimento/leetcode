import org.junit.Test
import kotlin.test.assertEquals

/***
 * Converter Romanos para inteiros
 * https://leetcode.com/problems/roman-to-integer/
 */
class RomanToInteger13 {
    @Test
    fun testScenario() {
        assertEquals(1, romanToInt("I"))
        assertEquals(3, romanToInt("III"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(1994, romanToInt("MCMXCIV"))
    }

    private fun romanToInt(s: String): Int {
        val romanMap: Map<String, Int> = getRomanMap()
        var sum = 0
        var ignoredIndex = -1
        s.forEachIndexed { index, c ->
            if(index == ignoredIndex) return@forEachIndexed
            if(index < s.length - 1) {
                if(romanMap.containsKey(getNextIndex(c, s, index))) {
                    sum += romanMap[getNextIndex(c, s, index)] ?: 0
                    ignoredIndex = index + 1
                    return@forEachIndexed
                }
            }
            sum += romanMap[c.toString()] ?: 0
        }
        return sum
    }

    private fun getNextIndex(c: Char, s: String, index: Int) = "$c${s[index + 1]}"

    private fun getRomanMap(): Map<String, Int> {
        return mapOf(
            "M" to 1000,
            "CM" to 900,
            "D" to 500,
            "CD" to 400,
            "C" to 100,
            "XC" to 90,
            "L" to 50,
            "XL" to 40,
            "X" to 10,
            "IX" to 9,
            "V" to 5,
            "IV" to 4,
            "I" to 1
        )
    }
}