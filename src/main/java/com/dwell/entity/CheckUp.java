package com.dwell.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CheckUp {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "check_up_id")
    @Id
    private Integer checkUpId;

    @Column(name = "check_up_date")
    private LocalDate checkUpDate;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "viseral_fat")
    private Double viseralFat;

    @Column(name = "tsf")
    private Double tsf;

    @Column(name = "total_fat")
    private Double totalFat;

    @Column(name = "meta_age")
    private Integer metaAge;

    @Column(name = "bmi")
    private Integer bmi;

    @Column(name = "bmr")
    private Integer bmr;

    @Column(name = "ske_muscle")
    private Double skeMuscle;

    public Integer getCheckUpId() {
        return checkUpId;
    }

    public void setCheckUpId(Integer checkUpId) {
        this.checkUpId = checkUpId;
    }

    public LocalDate getCheckUpDate() {
        return checkUpDate;
    }

    public void setCheckUpDate(LocalDate checkUpDate) {
        this.checkUpDate = checkUpDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getViseralFat() {
        return viseralFat;
    }

    public void setViseralFat(Double viseralFat) {
        this.viseralFat = viseralFat;
    }

    public Double getTsf() {
        return tsf;
    }

    public void setTsf(Double tsf) {
        this.tsf = tsf;
    }

    public Double getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(Double totalFat) {
        this.totalFat = totalFat;
    }

    public Integer getMetaAge() {
        return metaAge;
    }

    public void setMetaAge(Integer metaAge) {
        this.metaAge = metaAge;
    }

    public Integer getBmi() {
        return bmi;
    }

    public void setBmi(Integer bmi) {
        this.bmi = bmi;
    }

    public Integer getBmr() {
        return bmr;
    }

    public void setBmr(Integer bmr) {
        this.bmr = bmr;
    }

    public Double getSkeMuscle() {
        return skeMuscle;
    }

    public void setSkeMuscle(Double skeMuscle) {
        this.skeMuscle = skeMuscle;
    }
}
