package com.byteland;

import com.byteland.solution.CityUnifier;
import com.byteland.solution.ValidationUtils;
import com.byteland.model.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Busra Icoz
 * @date 24/12/2018
 */
public class Main extends CityUnifier {

    /**
     * Getting necessary input from user (test case number, city number and road connection)
     * Sample Input Format :
     * Input:
     * 3 --> Test case number
     * 4 --> City number for first test case
     * 0 1 2 --> Roads connecting cities for first test case
     * 8 --> City number for second test case
     * 0 1 2 0 0 3 3 --> Roads connecting cities for second test case
     * 9 --> City number for third test case
     * 0 1 1 1 1 0 2 2 --> Roads connecting cities for third test case
     *
     * @return Returns minimum step finding results for unification for each cases
     */

    private List<Integer> getInputData() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> results = new ArrayList<>();

        System.out.println("Input:");
        int testCaseCount = Integer.parseInt(in.readLine());    //test case number
        ValidationUtils.isTestCountNotValid(testCaseCount);     // checking validation of test case number

        for (int i = 0; i < testCaseCount; i++) {
            int cityCount = Integer.parseInt(in.readLine());    // how many city is in the Byte land
            List<City> cityList = createCity(cityCount);        // create cities with ids

            String[] cityRoadArrayStr = in.readLine().split("\\s+");    // Roads connecting cities
            ValidationUtils.isInputDataNotValid(cityCount, cityRoadArrayStr);   // checking validation of input values

            List<Integer> citiesRoadMap = new ArrayList<>();
            for (String road : cityRoadArrayStr) {
                citiesRoadMap.add(Integer.parseInt(road));
            }
            linkCitiesWithGivenRoad(cityList, citiesRoadMap);
            results.add(calculateMinStepForUnification(cityList, 1));
        }
        return results;

    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        List<Integer> results = main.getInputData();
        System.out.println("Output:");
        results.forEach(System.out::println);
    }
}
