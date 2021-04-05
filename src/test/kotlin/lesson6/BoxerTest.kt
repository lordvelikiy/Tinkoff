package lesson6

import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class BoxerTest {

    @Test
    fun `dsl`() {

        val boxer = mockk<Boxer> {
            every { id } returns 3
            every { speed } returns 16
            every { weight } returns 42
        }

        assertAll("all comparisons",
            { assertEquals(3, boxer.id) },
            { assertEquals(16, boxer.speed) },
            { assertEquals(42, boxer.weight) }
        )
    }

    @Test
    fun `will Win`() {

        val boxer = boxer {
            id = 3
            speed = 16
            weight = 43
        }
        val boxer2 = boxer {
            id = 2
            speed = 16
            weight = 42
        }

        val result = boxer.willWin(boxer2)

        assertEquals(true, result)

    }
}