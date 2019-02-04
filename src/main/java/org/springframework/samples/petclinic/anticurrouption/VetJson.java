package org.springframework.samples.petclinic.anticurrouption;

import java.util.Set;

public class VetJson {

    private Set<SpecilityJson> specialties;
    private String firstName;
    private String lastName;
    private Integer id;
    private String newlyAdded;

    public Set<SpecilityJson> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<SpecilityJson> specialties) {
        this.specialties = specialties;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewlyAdded() {
        return newlyAdded;
    }

    public void setNewlyAdded(String newlyAdded) {
        this.newlyAdded = newlyAdded;
    }
}
