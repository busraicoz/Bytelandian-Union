package com.byteland.solution;

import com.byteland.model.City;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

/**
 * @author Busra Icoz
 * @date 24/12/2018
 */
public class CityUnifierTest extends CityUnifier {

    private List<City> testCityList = new ArrayList<>();
    private List<Integer> testCitiesRoadMap = new ArrayList<>();

    //Data creation method for preparation tests
    private void beforeTest(int cityNum, String[] testRoads) {
        for (int i = 0; i < cityNum; i++) {
            testCityList.add(new City(i));
        }
        for (String road : testRoads) {
            testCitiesRoadMap.add(Integer.parseInt(road));
        }
    }

    @BeforeTest
    public void before() {
        beforeTest(8, new String[]{"0", "1", "2", "0", "0", "3", "3"});
    }

    @Test(priority = 2 ,testName = "Test link Cities With Given Road")
    public void testLinkCitiesWithGivenRoad() {
        linkCitiesWithGivenRoad(testCityList, testCitiesRoadMap);
        assertEquals(calculateMinStepForUnification(testCityList, 1), 4);
    }

    @Test(priority = 3, dependsOnMethods = {"testLinkCitiesWithGivenRoad"},testName = "Test calculation minimum steps for unification")
    public void testCalculateMinStepForUnification() {
        linkCitiesWithGivenRoad(testCityList, testCitiesRoadMap);
        assertEquals(calculateMinStepForUnification(testCityList, 1), 4);
    }

    @Test(priority = 4, testName = "Test city status change became \"false\"")
    public void testClearCityUnifiedStatus() {
        clearCityUnifiedStatus(testCityList);
        for (City city : testCityList) {
            assertFalse(city.isUnited());
        }
    }

    @Test(priority = 1, testName = "Test city creation")
    public void testCreateCity() {
        assertEquals(createCity(8), testCityList);
    }
}