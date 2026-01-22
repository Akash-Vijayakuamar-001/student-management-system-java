import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(name, age, dept, email);

                    if (dao.addStudent(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    dao.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = Integer.parseInt(sc.nextLine());
                    dao.searchStudentById(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    Student updatedStudent = new Student(newName, newAge, newDept, newEmail);

                    if (dao.updateStudent(updateId, updatedStudent)) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Failed to update student.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    if (dao.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Failed to delete student.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

