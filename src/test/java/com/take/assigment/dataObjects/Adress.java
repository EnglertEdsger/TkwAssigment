package com.take.assigment.dataObjects;

public class Adress {
    private String searchPostCode;
    private String adress;
    private String postcode;
    private String city;
    private String name;
    private String phoneNumber;
    private String email;

    public Adress(String searchPostCode, String adress, String postcode, String city, String name, String phoneNumber, String email) {
        this.searchPostCode = searchPostCode;
        this.adress = adress;
        this.postcode = postcode;
        this.city = city;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Adress() {

    }

    public String getSearchPostCode() {
        return searchPostCode;
    }

    public void setSearchPostCode(String searchPostCode) {
        this.searchPostCode = searchPostCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Address: main street 2415 PostCode: 8888AA City: Enschede Name:TestUser
    //PhoneNum:1234567890 e-mail:testuser@test.test
}
