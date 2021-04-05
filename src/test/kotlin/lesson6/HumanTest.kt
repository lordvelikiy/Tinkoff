package lesson6

import io.mockk.junit5.MockKExtension
import io.mockk.spyk
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@ExtendWith(MockKExtension::class)
class HumanTest {

    @Test
    fun `left to age`() {

        val human = Human("Svetlana", 16)
        val result = human.leftToAge(15)

        assertEquals("age normal", result)
    }

    @Test
    fun `left to age 2`() {

        val human = Human("Vasiliy", 13)
        val result = human.leftToAge(17)

        assertEquals("need another 4 years", result)
    }

    @Test
    fun `identity of names`() {

        val human = Human("Vasiliy", 13)
        val human2 = Human("Vasiliy", 16)
        val result = human.identicalNames(human2)

        assertEquals(true, result)
    }

    @Test
    fun `identity of names 2`() {

        val human = Human("Vasiliy", 13)
        val human2 = Human("Svetlana", 16)
        val result = human.identicalNames(human2)

        assertEquals(false, result)
    }

    @ParameterizedTest
    @CsvSource(
        "Vasiliy, 14, 18, need another 4 years",
        "Vasiliy, 19, 12, age normal",
        "Svetlana, 24, 85, need another 61 years"
    )
    fun `parameterized test for left to age `(a: String, b: Int, c: Int, expected: String) {

        val human = spyk(Human(a, b))
        val result = human.leftToAge(c)

        Assertions.assertEquals(expected, result)
    }
}

