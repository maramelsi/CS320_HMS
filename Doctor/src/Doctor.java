import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.*;
public class Doctor {
    static int doctor_id;
    static String fname;
    static String lname;
    double height;
    double weight;
    static String field;
    static String blood_type;

    static String user = "root";
    static String password = "1234";
    static String url = "jdbc:mysql://localhost:3306/cs320?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static Connection myConn;
    static Scanner scan=new Scanner(System.in);
    static {
        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    static Statement statement;
    static ResultSet resultSet;

    static {
        try {
            statement = myConn.createStatement();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    static String password1="12345";
    static String password2="11223";
    static String password3="22113";
    static String password4="33112";
    static String password5="33221";
    static String password6="12312";
    static String password7="21321";
    static String password8="54321";
    static String password9="32145";
    static String password10="45123";

    public static int login() {
        System.out.println("Please enter your doctor id: ");
        int id = scan.nextInt();
        if (id == 1) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password1)) {
                doctor_id=1;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 2) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password2)) {
                doctor_id=2;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 3) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password3)) {
                doctor_id=3;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 4) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password4)) {
                doctor_id=4;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 5) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password5)) {
                doctor_id=5;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 6) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password6)) {
                doctor_id=6;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 7) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password7)) {
                doctor_id=7;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 8) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password8)) {
                doctor_id=8;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 9) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password9)) {
                doctor_id=9;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 10) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(password10)) {
                doctor_id=10;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else {
            System.out.println("Invalid user id!");
        }



        return doctor_id;

    }

    public static void view_doctor_profile() throws SQLException{
        int id=login();
        PreparedStatement statement;
        String action = "SELECT * FROM cs320.doctor WHERE doctor_id= ? ";
        statement = myConn.prepareStatement(action);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("doctor_id"));
            System.out.print("  ");
            System.out.print(resultSet.getString("doctor_fname"));
            System.out.print("  ");
            System.out.print(resultSet.getString("doctor_lname"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_field"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_bloodtype"));
            System.out.print("    ");
            System.out.print(resultSet.getString("d_weight"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_height"));
    }
    /*public static void view_patient_list() throws SQLException{

    }*/
    public static void open_reservation_system() throws SQLException{

    }
    public static void edit_patient_data() throws SQLException{

    }

    }
