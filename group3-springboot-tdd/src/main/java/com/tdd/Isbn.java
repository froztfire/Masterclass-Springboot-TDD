package com.tdd;

import java.util.Objects;

public class Isbn {

    private String isbnNumber;

    public Isbn(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public static Isbn of(String isbnNumber) throws InvalidIsbnException {
        //write a validation  if ISBN10 or ISBN13 if not throw exception
        if (Objects.isNull(isbnNumber)) {
            return null;
        }

        String validIsbnValue = IsbnValidator.getValidatedValue(isbnNumber);

        return new Isbn(validIsbnValue);

    }

    @Override
    public String toString() {
        String ret = isbnNumber.replaceAll("[^A-Za-z0-9]", "");
        System.out.println(ret);
        return ret;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

}
