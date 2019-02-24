package com.byteland.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Busra Icoz
 * @date 24/12/2018
 */

public class City {

    private int cityId;
    private boolean united;
    private Set<City> neighbors = new HashSet<>();

    public City(int id) {

        this.cityId = id;
    }

    private int getCityId() {

        return cityId;
    }

    public boolean isUnited() {

        return this.united;
    }

    public void setUnited(boolean united) {

        this.united = united;
    }

    @Override
    public boolean equals(Object obj) {

        return this.getCityId() == ((City) obj).getCityId();
    }

    public Set<City> getNeighbors() {

        return this.neighbors;
    }

    public void setNeighbors(Set<City> relatedCityList) {

        this.neighbors = relatedCityList;
    }

    public void removeNeighbor(City neighbor) {

        this.getNeighbors().remove(neighbor);
    }

    public void addNeighbor(City neighbor) {

        this.getNeighbors().add(neighbor);
    }

    public int getNeighborSize() {

        return neighbors.size();
    }
}