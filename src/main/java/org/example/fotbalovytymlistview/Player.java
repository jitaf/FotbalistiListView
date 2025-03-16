package org.example.fotbalovytymlistview;

public class Player {
    private String name;
    private String position;
    private int rating;

    public Player(String name, String position, int rating) {
        this.name = name;
        this.position = position;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getPosition() { return position; }
    public int getRating() { return rating; }

    public void setName(String name) { this.name = name; }
    public void setPosition(String position) { this.position = position; }
    public void setRating(int rating) { this.rating = rating; }

    @Override
    public String toString() {
        return name + " - " + position;
    }
}
