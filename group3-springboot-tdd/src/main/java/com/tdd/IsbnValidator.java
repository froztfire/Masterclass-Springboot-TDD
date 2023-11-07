package com.tdd;

import java.util.List;

public class IsbnValidator {

    public static String getValidatedValue(String isbn) throws InvalidIsbnException {

        String cleanedIsbn = isbn.replaceAll("[^A-Za-z0-9]", "");
        ChecksumDigitForIsbn checksumDigit = new ChecksumDigitForIsbn();
        String lastIndex = "";

        String ret = "";
        if (cleanedIsbn.trim().length() == 10){
            lastIndex = cleanedIsbn.substring(9);
          ret = checksumDigit.getChecksumDigitForIsbnTen(cleanedIsbn);
        } else if (cleanedIsbn.trim().length() == 13) {
            lastIndex = cleanedIsbn.substring(12);
            ret = checksumDigit.getChecksumDigitForIsbnThirteen(cleanedIsbn);
        } else throw new InvalidIsbnException("Invalid ISBN Format");

//        System.out.println(lastIndex + "|" + ret);

        if (!lastIndex.equalsIgnoreCase(ret)){
            throw new InvalidIsbnException("Invalid ISBN Format");
        }
        return isbn;
    }

    static class ChecksumDigitForIsbn {

        public String getChecksumDigitForIsbnTen(String isbn) {

            int t, sum = 0;
            for (int i = 0; i < isbn.length()-1; i++) {
                int intNumber = Integer.parseInt(isbn.substring(i, i+1));
                sum = sum + ((i + 1) * intNumber);
            }
            t = sum % 11;
            if (t == 10){
                return "X";
            }
            return String.valueOf(t);
        }

        public String getChecksumDigitForIsbnThirteen(String isbn) {
            int t, sum = 0, flag = 0;
            for (int i = 0; i < isbn.length()-1; i++) {
                int intNumber = Integer.parseInt(isbn.substring(i, i+1));
                if (flag == 0){
                    sum = sum + intNumber;
                    flag = 1;
                }else {
                    sum = sum + (3 * intNumber);
                    flag = 0;
                }
            }
            t = sum % 10;
            t = 10 - t;
            if (t == 10){
                return "0";
            }
            return String.valueOf(t);
        }
    }
}


