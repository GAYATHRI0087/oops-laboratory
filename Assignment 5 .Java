//gayathri P
//2117240070087

PROGRAM:
import java.sql.*;
import java.util.Scanner;

public class ToDoAppJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/todo_db";
    static final String USER = "root";  // your MySQL username
    static final String PASS = "";      // your MySQL password

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== TO-DO APP =====");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Mark as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: viewTasks(); break;
                case 2:
                    System.out.print("Enter new task: ");
                    String task = sc.nextLine();
                    addTask(task);
                    break;
                case 3:
                    System.out.print("Enter task ID to complete: ");
                    int id = sc.nextInt();
                    completeTask(id);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int delId = sc.nextInt();
                    deleteTask(delId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addTask(String taskName) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "INSERT INTO tasks (task_name, status) VALUES (?, 'Pending')";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, taskName);
            ps.executeUpdate();
            System.out.println(" Task added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewTasks() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM tasks");
            System.out.println("\nID\tTask\t\tStatus");
            System.out.println("----------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getString("task_name") + "\t" +
                                   rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void completeTask(int id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "UPDATE tasks SET status='Completed' WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println(" Task marked as completed!");
            else
                System.out.println(" Task ID not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteTask(int id) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "DELETE FROM tasks WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Task deleted!");
            else
                System.out.println(" Task ID not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
