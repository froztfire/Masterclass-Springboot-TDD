package com.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class IsbnTest {

    @Test
    void testOfMethodWhenIsbnIsNull() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of(null);

        //When //Then
        assertNull(isbn);
    }

    @Test
    void testOfMethodWhenIsbnIsIsbn10() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of("0 321 14653 0");

        //When //Then
        assertNotNull(isbn);
    }

    @Test
    void testOfMethodWhenIsbnIsIsbn13() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of("978 0 471 48648 0");

        //When //Then
        assertNotNull(isbn);
    }

    @Test
    void testIsbn10ConversionFormat() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of("0 321 14653 0");
        String expectedValue = "0 321 14653 0";

        //When //Then
        assertEquals(expectedValue, isbn.getIsbnNumber());
    }

    @Test
    void testIsbn13ConversionFormat() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of("978 0 471 48648 0");
        String expectedValue = "978 0 471 48648 0";

        //When //Then
        assertEquals(expectedValue, isbn.getIsbnNumber());
    }

    @Test
    void testIsbn10ToString() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of("0 321 14653 0");
        String expectedValue = "0321146530";

        //When //Then
        assertEquals(expectedValue, isbn.toString());
    }

    @Test
    void testIsbn13ToString() throws InvalidIsbnException {
        //Given
        Isbn isbn = Isbn.of("978 0 471 48648 0");
        String expectedValue = "9780471486480";

        //When //Then
        assertEquals(expectedValue, isbn.toString());
    }

    @Test
    public void testIsbnException() throws InvalidIsbnException {
        //Given
        String invalidIsbn = "0 321 14653 &";
        String expectedMessage = "Invalid ISBN Format";

       // Then
        try {
            String actual = IsbnValidator.getValidatedValue(invalidIsbn);
        } catch (InvalidIsbnException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }
}