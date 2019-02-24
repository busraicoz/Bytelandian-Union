package com.byteland.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.byteland.model.City;

/**
 * @author Busra Icoz
 * @date 24/12/2018
 */

public class CityUnifier {

    /**
     * Calculated minimum step for unification
     *
     * @param cityList  - City list for unification
     * @param stepCount - Unification step counter
     */
    protected static int calculateMinStepForUnification(List<City> cityList, int stepCount) {
        List<City> nextStepList = new ArrayList<>();
        for (City city : cityList) {
            if (!city.isUnited()) {
                City willJoinCity = findNotLinkedCity(city);
                if (willJoinCity != null) {
                    linkSourceCitiesRoadsToTargetCity(willJoinCity, city);
                    nextStepList.add(city);             // take this city to next step
                    willJoinCity.setUnited(true);       // Unification status  became "true".
                    city.setUnited(true);
                } else {
                    nextStepList.add(city);             // take this city directly to next step
                    city.setUnited(true);               // Unification status  became "true".
                }
            }
        }

        if (nextStepList.size() == 1) {
            return stepCount;
        } else {
            clearCityUnifiedStatus(nextStepList);
            return calculateMinStepForUnification(nextStepList, stepCount + 1);
        }

    }

    /**
     * Clear City Unified Status
     *
     * @param cityList - City List for to make unified status "false".
     */
    static void clearCityUnifiedStatus(List<City> cityList) {
        for (City city : cityList) {
            city.setUnited(false);
        }
    }

    /**
     * Linked source cities roads to target city
     *
     * @param sourceCity      - Source city for linked road
     * @param destinationCity - Destination city for linked road
     */
    private static void linkSourceCitiesRoadsToTargetCity(City sourceCity, City destinationCity) {

        sourceCity.removeNeighbor(destinationCity);
        destinationCity.removeNeighbor(sourceCity);

        for (City city : sourceCity.getNeighbors()) {

            destinationCity.addNeighbor(city);

            city.removeNeighbor(sourceCity);
        }
        sourceCity.setNeighbors(new HashSet<>());

    }

    /**
     * Finding Mininimum linked and not united city
     *
     * @param city - City for finding mininimum linked and not united city
     * @return City
     */
    private static City findNotLinkedCity(City city) {

        int minRoadCount = ValidationUtils.getMaxCityCount() - 1; //
        City minLCityLinked = null;

        for (City tempCity : city.getNeighbors()) {
            if (!tempCity.isUnited()) {
                if (tempCity.getNeighborSize() < minRoadCount) {
                    minRoadCount = tempCity.getNeighborSize();
                    minLCityLinked = tempCity;
                }
            }
        }
        return minLCityLinked;

    }

    /**
     * Linked Cities With Given Road
     *
     * @param cityList      - City List
     * @param citiesRoadMap - Road map for this cities
     */
    protected static void linkCitiesWithGivenRoad(List<City> cityList, List<Integer> citiesRoadMap) {
        for (int i = 0; i < citiesRoadMap.size(); i++) {
            cityList.get(i + 1).addNeighbor(cityList.get(citiesRoadMap.get(i)));
            cityList.get(citiesRoadMap.get(i)).addNeighbor(cityList.get(i + 1));
        }
    }

    /**
     * Created City
     *
     * @param cityNum - City number for create cities
     * @return City list
     */
    protected static List<City> createCity(int cityNum) {
        List<City> list = new ArrayList<>();
        for (int i = 0; i < cityNum; i++) {
            list.add(new City(i));
        }
        return list;
    }
}
