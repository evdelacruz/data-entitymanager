package com.evdelacruz.samples.dataentitymanager.service.datasource.domain;

import com.evdelacruz.samples.dataentitymanager.util.data.domain.AbstractEntity;
import javax.persistence.*;

@Entity
@Table(name="user", schema="public")
public class User extends AbstractEntity {
    private static final long serialVersionUID = -1409482590620487826L;
    private int id;
    private Profile profile;
    private String username;
    private String password;
    private boolean enabled;

    public User() {}

    //<editor-fold desc="Encapsulation">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (null != this.profile) {
            this.profile.setUser(this);
        }
    }

    @Column(name="username", nullable=false, length=50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password", nullable=false, length=100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="enabled", nullable=false)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    //</editor-fold>
}
