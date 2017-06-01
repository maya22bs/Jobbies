package com.androidcamp.jobbies;

import java.util.Date;

/**
 * Created by Alina Dubatovka on 8/4/16.
 */
public class Job {
    private final JobDescription description;
    private final User user;
    private final String id;

    public Job(String id, JobDescription description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

    public Job(String title, String descr, String address)
    {
        user = null;
        id = null;
        description = new JobDescription(title, descr, address);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return description.getTitle();
    }

    public void setTitle(String title) {
        description.setTitle(title);
    }

    public void setDescription(String description) {
        this.description.setDescription(description);
    }

    public Payment getPayment() {
        return description.getPayment();
    }

    public void setPayment(Payment payment) {
        description.setPayment(payment);
    }

    public String getCategory() {
        return description.getCategory();
    }

    public void setCategory(String category) {
        description.setCategory(category);
    }

    public Date getDate() {
        return description.getDate();
    }

    public void setDate(Date dates) {
        description.setDate(dates);
    }

    public boolean isVoluntary() {
        return description.getIsVoluntary();
    }

    public void setVoluntary(boolean voluntary) {
        description.setIsVoluntary(voluntary);
    }

    public String getShortDescription() {
        return description.getShortDescription();
    }

    public JobDescription getDescription() {
        return description;
    }


    public String getName() {
        return user.getName();
    }

    public void setName(String name) {
        user.setName(name);
    }

    public String getImageURL() {
        return user.getImageURL();
    }

    public void setImageURL(String imageURL) {
        user.setImageURL(imageURL);
    }

    public String getUserId() {
        return user.getId();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public String getOwnerId() {
        return description.getOwnerId();
    }

    public void setOwnerId(String ownerId) {
        description.setOwnerId(ownerId);
    }
}
