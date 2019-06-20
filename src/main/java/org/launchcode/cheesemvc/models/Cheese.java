package org.launchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cheese {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @NotNull
    @Size(min = 1, message = "Description can not be empty")
    private String description;

    private CheeseType type;
    @Min(1)
    @Max(5)
    private int ratings;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }
}
