package com.vsct.hexagonalcqrs.core.infrastructure.users;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("user")
public class UserDocument {
    @Id
    private String id;
    private String email;
    private String name;
    private LocalDateTime subscriptionDate;

    public UserDocument() {
    }

    public UserDocument(String id, User user, LocalDateTime subscriptionDate) {
        this.id = id;
        email = user.getEmail();
        name = user.getName();
        this.subscriptionDate = subscriptionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public UserView toUserView() {
        return new UserView(email, name, subscriptionDate);
    }
}
