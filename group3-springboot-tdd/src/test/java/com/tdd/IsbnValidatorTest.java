package com.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class IsbnValidatorTest {

    @Test
    @DisplayName("Validate ISBN-10 Example 1 : 0471958697")
    void testToValidateIsbn10Example1() {
        //Given
        String isbn = "0471958697";

        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
            assertEquals(isbn, actual);
        } catch (InvalidIsbnException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("Validate ISBN-10 Example 2 : 0 321 14653 0")
    void testToValidateIsbn10Example2() {
        //Given
        String isbn = "0 321 14653 0";

        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
            assertEquals(isbn, actual);
        } catch (InvalidIsbnException e) {
            assertTrue(false);
        }
    }
    @Test
    @DisplayName("Validate ISBN-10 Example 3 : 0-123-45672-X")
    void testToValidateIsbn10Example3() {
        //Given
        String isbn = "0-123-45672-X";

        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
            assertEquals(isbn, actual);
        } catch (InvalidIsbnException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("Validate ISBN-13 Example 1 : 9780470059029")
    void testToValidateIsbn13Example1() {
        //Given
        String isbn = "9780470059029";

        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
            assertEquals(isbn, actual);
        } catch (InvalidIsbnException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("Validate ISBN-13 Example 2 : 978 0 471 48648 0")
    void testToValidateIsbn13Example2() {
        //Given
        String isbn = "978 0 471 48648 0";

        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
            assertEquals(isbn, actual);
        } catch (InvalidIsbnException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("Validate ISBN-13 Example 3 : 978-0596809485")
    void testToValidateIsbn13Example3() {
        //Given
        String isbn = "978-0596809485";

        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
            assertEquals(isbn, actual);
        } catch (InvalidIsbnException e) {
            assertTrue(false);
        }
    }

    @Test
    @DisplayName("Invalidate ISBN-10")
    void testGetValidatedValueForIsbn10ThrowException() {
        //Given
        String isbn = "978-05968";
        String expectedMessage = "Invalid ISBN Format";
        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
        } catch (InvalidIsbnException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    @DisplayName("Invalidate ISBN-13")
    void testGetValidatedValueForIsbn13ThrowException() {
        //Given
        String isbn = "978-05968-3456789";
        String expectedMessage = "Invalid ISBN Format";
        //When //Then
        try {
            String actual = IsbnValidator.getValidatedValue(isbn);
        } catch (InvalidIsbnException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }
}