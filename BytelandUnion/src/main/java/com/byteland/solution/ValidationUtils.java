package com.byteland.solution;

import com.byteland.exception.InvalidInputException;

/**
 * @author Busra Icoz
 * @date 24/12/2018
 */

public class ValidationUtils {
    private static final int MAX_CITY_COUNT = 600; //maximum city count
    private static final int MIN_CITY_COUNT = 2;   // minimum city count

    private static final int MAX_TEST_COUNT = 1000; // maximum test case count
    private static final int MINT_TEST_COUNT = 1;  // minimum test case count

    /**
     * Checking user's input validation
     *
     * @param numberOfCities  - Number of cities
     * @param connectedCities - Roads connecting cities
     */
    public static void isInputDataNotValid(int numberOfCities, String[] connectedCities) throws InvalidInputException {
        if (numberOfCities < MIN_CITY_COUNT) {
            throw new InvalidInputException("At least " + MIN_CITY_COUNT + " cities are needed.");
        }
        if (numberOfCities > MAX_CITY_COUNT) {
            throw new InvalidInputException("Maximum city number should be  " + MAX_CITY_COUNT);
        }
        if (connectedCities.length + 1 != numberOfCities) {
            throw new InvalidInputException("Connections of cities are not valid (Connected cities number should be \"city number -1\" )");
        }
    }

    /**
     * Checking test case number validation
     *
     * @param testCount - Number of test cases
     */

    public static void isTestCountNotValid(int testCount) throws InvalidInputException {
        if (testCount < MINT_TEST_COUNT || testCount > MAX_TEST_COUNT) {
            throw new InvalidInputException("Test Count Not Valid (1< \"test count\" <1000)");
        }
    }

    /**
     * Maximum number of city
     */
    static int getMaxCityCount() {
        return MAX_CITY_COUNT;
    }
}
