package lesson6

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IntExtensionTest {
    @Test
    fun `test function extension`() {

        mockkStatic("lesson6.IntExtensionKt")
        every { 16.adult() }.returns(false)

        val result = 16.adult()

        assertEquals(result, false)
        verify { 16.adult() }
    }

    @Test
    fun `test function extension 2`() {

        mockkStatic("lesson6.IntExtensionKt")
        every { 44.adult() }.returns(true)

        val result = 44.adult()

        assertEquals(result, true)
        verify { 44.adult() }
    }

    @Test
    fun `exception call`() {

        mockkStatic("lesson6.IntExtensionKt")
        every { (-9).adult() } throws AgeException()

        assertThrows<AgeException> { (-9).adult() }
        verify { (-9).adult() }
    }
}
