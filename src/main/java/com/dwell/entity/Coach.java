package com.dwell.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coachid")
    private Integer coachId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "herbalife_id")
    private String herbalifeId;

    @Column(name = "fssai")
    private String fssai;

    @Column(name = "upline_tab_team")
    private String upLineTabTeam;

    @Column(name = "level_in_herbalife")
    private String levelInHerbalife;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "coach", targetEntity = Client.class)
    @JsonIgnore
    private List<Client> clients;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
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

    public String getHerbalifeId() {
        return herbalifeId;
    }

    public void setHerbalifeId(String herbalifeId) {
        this.herbalifeId = herbalifeId;
    }

    public String getFssai() {
        return fssai;
    }

    public void setFssai(String fssai) {
        this.fssai = fssai;
    }

    public String getUpLineTabTeam() {
        return upLineTabTeam;
    }

    public void setUpLineTabTeam(String upLineTabTeam) {
        this.upLineTabTeam = upLineTabTeam;
    }

    public String getLevelInHerbalife() {
        return levelInHerbalife;
    }

    public void setLevelInHerbalife(String levelInHerbalife) {
        this.levelInHerbalife = levelInHerbalife;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
