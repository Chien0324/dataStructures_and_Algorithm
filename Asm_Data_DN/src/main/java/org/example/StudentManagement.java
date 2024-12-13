package org.example;

public class StudentManagement {
    private StudentStack students;

    public StudentManagement() {
        this.students = new StudentStack();
    }

    public void addStudent(Student student) {
        try {
            if (student == null) {
                throw new IllegalArgumentException("Student object cannot be null.");
            }
            students.push(student);
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String newName, String newContactNumber, String address, double marks, String rank) {
        StudentStack tempStack = new StudentStack();
        boolean found = false;

        try {
            while (!students.isEmpty()) {
                Student student = students.pop();

                if (student.getId() == id) {
                    tempStack.push(new Student(id, newName, newContactNumber, address, marks, rank));
                    found = true;
                } else {
                    tempStack.push(student);
                }
            }

            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }

            if (!found) {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack();
        try {
            while (!students.isEmpty()) {
                Student student = students.pop();
                if (student.getId() != id) {
                    tempStack.push(student);
                }
            }

            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }

            System.out.println("Student with ID " + id + " has been deleted (if existed).");
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    public void bubbleSort() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        try {
            Student[] studentArray = new Student[students.size()];
            StudentStack tempStack = new StudentStack();
            int index = 0;

            while (!students.isEmpty()) {
                Student student = students.pop();
                studentArray[index++] = student;
                tempStack.push(student);
            }

            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }

            long startTime = System.nanoTime();
            for (int i = 0; i < studentArray.length - 1; i++) {
                for (int j = 0; j < studentArray.length - 1 - i; j++) {
                    if (studentArray[j].getMarks() > studentArray[j + 1].getMarks()) {
                        Student temp = studentArray[j];
                        studentArray[j] = studentArray[j + 1];
                        studentArray[j + 1] = temp;
                    }
                }
            }
            long endTime = System.nanoTime();

            for (int i = studentArray.length - 1; i >= 0; i--) {
                students.push(studentArray[i]);
            }

            System.out.println("Students sorted using Bubble Sort.");
            System.out.println("Bubble Sort Time: " + (endTime - startTime) + " nanoseconds.");
        } catch (Exception e) {
            System.out.println("Error in Bubble Sort: " + e.getMessage());
        }
    }

    public void quickSort() {
        if (students.isEmpty()) {
            System.out.println("No students to sort.");
            return;
        }

        try {
            Student[] studentArray = new Student[students.size()];
            StudentStack tempStack = new StudentStack();
            int index = 0;

            while (!students.isEmpty()) {
                Student student = students.pop();
                studentArray[index++] = student;
                tempStack.push(student);
            }

            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }

            long startTime = System.nanoTime();
            quickSortHelper(studentArray, 0, studentArray.length - 1);
            long endTime = System.nanoTime();

            for (int i = studentArray.length - 1; i >= 0; i--) {
                students.push(studentArray[i]);
            }

            System.out.println("Students sorted using Quick Sort.");
            System.out.println("Quick Sort Time: " + (endTime - startTime) + " nanoseconds.");
        } catch (Exception e) {
            System.out.println("Error in Quick Sort: " + e.getMessage());
        }
    }

    private void quickSortHelper(Student[] studentArray, int low, int high) {
        if (low < high) {
            int pi = partition(studentArray, low, high);
            quickSortHelper(studentArray, low, pi - 1);
            quickSortHelper(studentArray, pi + 1, high);
        }
    }

    private int partition(Student[] studentArray, int low, int high) {
        try {
            Student pivot = studentArray[high];
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (studentArray[j].getMarks() <= pivot.getMarks()) {
                    i++;
                    Student temp = studentArray[i];
                    studentArray[i] = studentArray[j];
                    studentArray[j] = temp;
                }
            }

            Student temp = studentArray[i + 1];
            studentArray[i + 1] = studentArray[high];
            studentArray[high] = temp;

            return i + 1;
        } catch (Exception e) {
            System.out.println("Error in partitioning: " + e.getMessage());
            return -1;
        }
    }

    public void searchStudentById(int id) {
        StudentStack tempStack = new StudentStack();
        try {
            while (!students.isEmpty()) {
                Student student = students.pop();
                if (student.getId() == id) {
                    System.out.println("Found student: " + student.getName() +
                            ", Contact: " + student.getContactNumber() +
                            ", Address: " + student.getAddress() +
                            ", Marks: " + student.getMarks() +
                            ", Rank: " + student.getRank());
                    tempStack.push(student);
                    while (!tempStack.isEmpty()) {
                        students.push(tempStack.pop());
                    }
                    return;
                }
                tempStack.push(student);
            }

            System.out.println("Student with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("Error searching for student: " + e.getMessage());
        } finally {
            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        try {
            System.out.println("Current student list:");
            StudentStack tempStack = new StudentStack();
            while (!students.isEmpty()) {
                Student student = students.pop();
                System.out.println(student);
                tempStack.push(student);
            }

            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }
        } catch (Exception e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }
}                                          
