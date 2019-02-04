package org.springframework.samples.petclinic.anticurrouption;

public class SpecilityJson {

    private Integer id;

    private String name;

    private String newlyAdded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewlyAdded() {
        return newlyAdded;
    }

    public void setNewlyAdded(String newlyAdded) {
        this.newlyAdded = newlyAdded;
    }
}
