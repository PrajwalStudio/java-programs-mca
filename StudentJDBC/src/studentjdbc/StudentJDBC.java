package studentjdbc;
import java.sql.*;
import java.util.Scanner;

public class StudentJDBC{
    public static void main(String[] args) {
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prajwal", "root", "root");
            Scanner sc = new Scanner(System.in);
            Statement st = con.createStatement()
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            int ch;
            do {
                System.out.println("\n1.Insert 2.Delete 3.Update 4.Search 5.Display 6.Exit");
                System.out.print("Choice: ");
                ch = sc.nextInt(); sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        st.executeUpdate("INSERT INTO Student VALUES(" + id + ", '" + name + "', '" + email + "')");
                        System.out.println("Inserted.");
                        break;

                    case 2:
                        System.out.print("ID to delete: "); int did = sc.nextInt();
                        st.executeUpdate("DELETE FROM Student WHERE id=" + did);
                        System.out.println("Deleted.");
                        break;

                    case 3:
                        System.out.print("ID to update: "); int uid = sc.nextInt(); sc.nextLine();
                        System.out.print("New Name: "); String nname = sc.nextLine();
                        System.out.print("New Email: "); String nemail = sc.nextLine();
                        st.executeUpdate("UPDATE Student SET name='" + nname + "', email='" + nemail + "' WHERE id=" + uid);
                        System.out.println("Updated.");
                        break;

                    case 4:
                        System.out.print("ID to search: "); int sid = sc.nextInt();
                        ResultSet rs = st.executeQuery("SELECT * FROM Student WHERE id=" + sid);
                        if (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id"));
                            System.out.println("Name: " + rs.getString("name"));
                            System.out.println("Email: " + rs.getString("email"));
                        } else {
                            System.out.println("Not found.");
                        }
                        break;

                    case 5:
                        ResultSet all = st.executeQuery("SELECT * FROM Student");
                        System.out.println("ID\tName\t\tEmail");
                        while (all.next()) {
                            System.out.println(all.getInt("id") + "\t" + all.getString("name") + "\t\t" + all.getString("email"));
                        }
                        break;

                    case 6:
                        System.out.println("Bye!");
                        break;

                    default:
                        System.out.println("Invalid.");
                }

            } while (ch != 6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
