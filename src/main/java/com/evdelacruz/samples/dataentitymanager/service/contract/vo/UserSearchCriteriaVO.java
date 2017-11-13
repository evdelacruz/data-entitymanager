package com.evdelacruz.samples.dataentitymanager.service.contract.vo;

import javax.validation.constraints.AssertTrue;
import java.io.Serializable;

public class UserSearchCriteriaVO implements Serializable {
    private static final long serialVersionUID = 2096455582156198648L;
    private String name;
    private String username;
    private Boolean enabled;

    public UserSearchCriteriaVO() {}

    @AssertTrue
    public boolean isValidCriteria() {
        return null != name || null != username || null != enabled;
    }

    //<editor-fold desc="Encapsulation">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    //</editor-fold>
}
