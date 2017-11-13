package com.evdelacruz.samples.dataentitymanager.service.contract.vo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProfileVO implements Serializable {
    private static final long serialVersionUID = -3594339070668120474L;
    private String givenNames;
    private String surnames;
    private String email;
    private int age;

    public ProfileVO() {}

    //<editor-fold desc="Encapsulation">
    @NotBlank
    @Size(min=1, max=100)
    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    @NotBlank
    @Size(min=1, max=100)
    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Min(18)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //</editor-fold>
}
