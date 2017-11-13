package com.evdelacruz.samples.dataentitymanager.service.datasource.query;

import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.Profile;
import com.evdelacruz.samples.dataentitymanager.service.datasource.domain.User;
import com.evdelacruz.samples.dataentitymanager.util.data.query.AbstractSearchCriteria;
import javax.persistence.criteria.*;

public class UserSearchCriteria extends AbstractSearchCriteria<User> {
    private String name;
    private String username;
    private Boolean enabled;

    @Override
    public Predicate getPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        this.addPredicate(() -> null != enabled, () -> builder.equal(root.get("enabled"), enabled));
        this.addPredicate(() -> null != username, () -> builder.like(builder.lower(root.get("username")), String.format("%%%s%%", username.toLowerCase())));
        this.addNamePredicate(root, builder);
        return this.build(builder);
    }

    private void addNamePredicate(Root<User> root, CriteriaBuilder builder) {
        if (null != name) {
            Join<Profile, User> profile = root.join("profile", JoinType.INNER);
            profile.on(builder.or(builder.like(builder.lower(profile.get("givenNames")), String.format("%%%s%%", name.toLowerCase())),
                                  builder.like(builder.lower(profile.get("surnames")), String.format("%%%s%%", name.toLowerCase()))));
        }
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
