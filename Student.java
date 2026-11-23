import java.util.Scanner;

public class Student {
    public Student(String stuUSN, String stuName, String stuBranch, String stuPhone) {
        System.out.println("Student USN: " + stuUSN);
        System.out.println("Student Name: " + stuName);
        System.out.println("Student Branch: " + stuBranch);
        System.out.println("Student Phone Number: " + stuPhone);
        System.out.println("--------------------------");
    }
    public static void main(String[] args) {
        Scanner readInput = new Scanner(System.in);
        System.out.println("Enter number of student objects to create:");
        int numberOfStudents = readInput.nextInt();
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.println("Enter Student USN:");
            String usn = readInput.next();
            System.out.println("Enter Student Name:");
            String name = readInput.next();
            System.out.println("Enter Student Branch:");
            String branch = readInput.next();
            System.out.println("Enter Student Phone:");
            String phone = readInput.next();
            new Student(usn, name, branch, phone);
        }
        readInput.close();
    }
}