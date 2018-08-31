package com.example.uptech.newpharma.common_desaes;

/**
 * Created by uptech on 11/08/2018.
 */

public class diseases {


    private String category;
    private String id ;
    private String name ;
    private String price ;
    private  String Desciption;
    private String symptom;
    public diseases() {
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getSymptom() {

        return symptom;
    }

    public void setDesciption(String desciption) {
        Desciption = desciption;
    }

    public String getDesciption() {

        return Desciption;
    }

    public diseases(String category, String id, String name, String price) {

        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
