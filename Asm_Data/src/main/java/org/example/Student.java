package org.example;

public class Student {
    private int id;
    private String name;
    private String contactNumber;
    private String address;
    private String marks;
    private String rank;

    public Student(int id, String name, String contactNumber, String address, String marks, String rank) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.marks = marks;
        this.rank = rank;
    }




    // Getter và Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMarks() {
        return marks;
    }



    public String getRank() {
        return rank;
    }

   @Override public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", contactNumber='" + contactNumber + '\'' +
            ", address='" + address + '\'' +
            ", marks=" + marks +
            ", rank='" + rank + '\'' +
            '}';
}}
