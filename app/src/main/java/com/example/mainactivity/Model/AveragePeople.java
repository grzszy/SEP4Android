package com.example.mainactivity.Model;

public class AveragePeople {


    /**
     * @author Jakob Hansen
     *
     */

    private int averageNumberOfPeople;

    /**
     * Constructor for AveragePeople class.
     * @param averageNumberOfPeople
     */
    public AveragePeople(int averageNumberOfPeople){
        this.averageNumberOfPeople = averageNumberOfPeople;
    }

    /**
     * Getter for average number of people.
     * @return Average number of people.
     */
    public int getAverageNumberOfPeople() {
        return averageNumberOfPeople;
    }

    /**
     * Setter for average number of people.
     * @param averageNumberOfPeople
     */
    public void setAverageNumberOfPeople(int averageNumberOfPeople) {
        this.averageNumberOfPeople = averageNumberOfPeople;
    }
}
