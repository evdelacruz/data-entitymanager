package com.evdelacruz.samples.dataentitymanager.service.datasource.domain;

import com.evdelacruz.samples.dataentitymanager.util.data.domain.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;

@Entity
@Table(name="profile")
public class Profile extends AbstractEntity {
    private static final long serialVersionUID = 1732469162226123627L;
    private int id;
    private User user;
    private String givenNames;
    private String surnames;
    private String email;
    private int age;

    public Profile() {}

    //<editor-fold desc="Encapsulation">
    @Id
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="user")})
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name="given_names", nullable=false, length=100)
    public String getGivenNames() {
        return givenNames;
    }

    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    @Column(name="surnames", nullable=false, length=100)
    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    @Column(name="email", nullable=false, length=50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="age", nullable=false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //</editor-fold>
}
