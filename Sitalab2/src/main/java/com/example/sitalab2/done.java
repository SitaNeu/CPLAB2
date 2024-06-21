package com.example.sitalab2;

public class done {


    private int StudentID;
    private String  FirstName;

    private String LastName;

    private String Address;

    public done(int StudentID, String FirstName, String LastName, String Address) {
        this.StudentID= StudentID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address= Address;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setId(int StudentID) {
        this.StudentID =StudentID;
    }

    public String getName() {
        return FirstName;
    }

    public void setName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getEmail() {
        return LastName;
    }

    public void setEmail(String LastName) {
        this.LastName = LastName;
    }

    public String getPassword() {
        return Address;
    }

    public void setPassword(String Address) {
        this.Address = Address;
    }
}
