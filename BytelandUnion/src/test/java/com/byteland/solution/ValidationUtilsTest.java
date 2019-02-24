package com.byteland.solution;

import com.byteland.exception.InvalidInputException;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class ValidationUtilsTest {

private String[] testRoads= {"0","1","2","0","0","3","3"};
private String[] testRoads2= {"0","1","1","1","1","0","0","2"};

    @Test(expectedExceptions=InvalidInputException.class, testName = "Checking city number  value for invalid maximum number")
    public void testIsInputDataNotValidForMax() throws InvalidInputException {
        ValidationUtils.isInputDataNotValid(601,testRoads);
    }
    @Test(expectedExceptions=InvalidInputException.class, testName = "Checking city number  value for invalid minimum number")
    public void testIsInputDataNotValidForMin() throws InvalidInputException {
        ValidationUtils.isInputDataNotValid(1,testRoads);
    }

    @Test(expectedExceptions=InvalidInputException.class, testName = "Checking test road connection list size equal to number of cities")
    public void testIsInputDataNotValidForRoadConnectionNum() throws InvalidInputException {
        ValidationUtils.isInputDataNotValid(8,testRoads2);
    }

    @Test(expectedExceptions=InvalidInputException.class, testName = "Checking test case number  for invalid maximum number")
    public void testIsTestCountNotValidForMax() throws InvalidInputException {
        ValidationUtils.isTestCountNotValid(10000);
    }

    @Test(expectedExceptions=InvalidInputException.class, testName = "Checking test case number  for invalid minimum number")
    public void testIsTestCountNotValidForMin() throws InvalidInputException {
        ValidationUtils.isTestCountNotValid(0);
    }

    @Test(testName = "Checking max city number")
    public void testGetMaxCityCount() {
        assertEquals(ValidationUtils.getMaxCityCount(),600);
    }

}