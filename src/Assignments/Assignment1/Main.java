package Assignments.Assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(20, "Male", "Raj", 15, "FDS", 3, 8);
        Faculty f1 = new Faculty(45, "Male", "Shirole sir", 456, 100000, "Data Structures");
        //Printing the information that we gave as input
        System.out.println("Student Information: ");
        System.out.println("Name : " + s1.getName());
        System.out.println("Age : " + s1.getAge());
        System.out.println("Gender : " + s1.getGender());
        System.out.println("Roll No. : " + s1.getRoll_no());
        System.out.println("Classes : " + s1.getClasses());
        System.out.println("Semester : " + s1.getSemester());
        System.out.println("CPI : " + s1.getCpi());
        System.out.println(" ");
        System.out.println("Faculty Information: ");
        System.out.println("Name : " + f1.getName());
        System.out.println("Age : " + f1.getAge());
        System.out.println("Gender : " + f1.getGender());
        System.out.println("Employee ID : " + f1.getEmpID());
        System.out.println("Salary : " + f1.getSalary());
        System.out.println("Specalization : " + f1.getSpecalization());
        System.out.println(" ");

        //Updating the information
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new student information: ");
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter gender: ");
        String gender = sc.next();
        System.out.print("Enter Roll No: ");
        int roll_no = sc.nextInt();
        System.out.print("Enter classes: ");
        String classes = sc.next();
        System.out.print("Enter Semester: ");
        int Semester = sc.nextInt();
        System.out.print("Enter CPI: ");
        int cpi = sc.nextInt();

        //Initalizilg the updated information to a new object
        Student s2 = new Student(age, gender, name, roll_no, classes, Semester, cpi);
        System.out.println("Updated student information: ");
        System.out.println("Name : " + s2.getName());
        System.out.println("Age : " + s2.getAge());
        System.out.println("Gender : " + s2.getGender());
        System.out.println("Roll No. : " + s2.getRoll_no());
        System.out.println("Classes : " + s2.getClasses());
        System.out.println("Semester : " + s2.getSemester());
        System.out.println("CPI : " + s2.getCpi());


    }
}
