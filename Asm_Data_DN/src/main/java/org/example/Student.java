package org.example;

public class Student {
    private int id;
    private String name;
    private String contactNumber;
    private String address;
    private double marks;
    private String rank;

    public Student(int id, String name, String contactNumber, String address, double marks, String rank) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.marks = marks;
        this.rank = rank;
    }


    public void setRank() {
        if (marks > 90) {
            this.rank = "Excellent";
        } else if (marks >= 75) {
            this.rank = "Good";
        } else if (marks >= 60) {
            this.rank = "Medium";
        } else if (marks >= 50) {
            this.rank = "Fall";
        } else {
            this.rank = "Fail";
        }
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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        setRank();
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
    }
}                                      // đây là đoạn code ADT Của mình trong ứng dụng quản lý sinh viên. Bạn không cần phân tích, mà chỉ chần viết lại đoạn code này thôi.
