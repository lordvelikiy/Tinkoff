package lesson6

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DAOTest {
    private val list = listOf(
        Boxer(1, 16, 93),
        Boxer(2, 14, 72),
        Boxer(3, 22, 84),
        Boxer(4, 40, 60),
        Boxer(5, 17, 83),
        Boxer(6, 8, 120)
    )

    @Test
    fun `select All Boxer `() {

        val dao = mockk<DAO>()
        every { dao.selectAll() } returns list
        val res = dao.selectAll()

        assertEquals(list == res, true)
    }

    @Test
    fun `select by ID`() {

        val dao = mockk<DAO>()
        every { dao.selectByID(4) } returns list[3]
        val res = dao.selectByID(4)

        Assertions.assertEquals(list[3], res)
    }

    @Test
    fun `exceed the  list size `() {
        val dao = mockk<DAO>()
        every { dao.selectByID(7) } throws ArrayIndexOutOfBoundsException()

        assertThrows<ArrayIndexOutOfBoundsException> { dao.selectByID(7) }
        verify { dao.selectByID(7) }
    }
}