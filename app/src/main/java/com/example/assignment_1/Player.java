package com.example.assignment_1;

import java.io.Serializable;

public class Player implements Serializable {
    private String thumbnail, image, name, fullname, number, position, age, appearances, goals, country, joined, quote, kit, kiturl, kitprice, url;

    public Player(String thumbnail, String image, String name, String fullname, String number, String position, String age, String appearances, String goals, String country, String joined, String quote, String kit, String kiturl, String kitprice, String url) {
        this.thumbnail = thumbnail;
        this.image = image;
        this.name = name;
        this.fullname = fullname;
        this.number = number;
        this.position = position;
        this.age = age;
        this.appearances = appearances;
        this.goals = goals;
        this.country = country;
        this.joined = joined;
        this.quote = quote;
        this.kit = kit;
        this.kiturl = kiturl;
        this.kitprice = kitprice;
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAppearances() {
        return appearances;
    }

    public void setAppearances(String appearances) {
        this.appearances = appearances;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getKit() {
        return kit;
    }

    public void setKit(String kit) {
        this.kit = kit;
    }

    public String getKiturl() {
        return kiturl;
    }

    public void setKiturl(String kiturl) {
        this.kiturl = kiturl;
    }

    public String getKitprice() {
        return kitprice;
    }

    public void setKitprice(String kitprice) {
        this.kitprice = kitprice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
