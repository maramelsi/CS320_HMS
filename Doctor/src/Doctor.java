import java.sql.*;
import java.util.Scanner;
public class Doctor {
    static int doctor_id;
    static String user = "root";
    static String password = "1234";
    static String url = "jdbc:mysql://localhost:3306/cs320?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static Connection myConn;
    static Scanner scan = new Scanner(System.in);
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
    static String doc_password1="abcd";
    static String doc_password2="dcba";
    static String doc_password3="bacd";
    static String doc_password4="cdba";
    

    //A function that views the doctor information given their id
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
            System.out.print(resultSet.getString("doctor_name"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_field"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_bloodtype"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_weight"));
            System.out.print("  ");
            System.out.print(resultSet.getString("d_height"));
        }
    }
    //A function that views all past and upcoming appointments given a doctor id
    public static void view_all_appointments() throws SQLException{
        int id=login();
        PreparedStatement statement;
        String action = "select * from cs320.appointment where doctor_id= ? ";
        statement = myConn.prepareStatement(action);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("appointment_no"));
            System.out.print("  ");
            System.out.print(resultSet.getTimestamp("ap_datetime"));
            System.out.print("  ");
            System.out.print(resultSet.getInt("patient_id"));
            System.out.print("  ");
            System.out.print(resultSet.getInt("doctor_id"));
            System.out.print("  ");
            System.out.print(resultSet.getString("polyclinic"));
        }
    }
    //A function that lets doctors add their starting and ending available dates and times to the availability table in the database
    public static void available_times() throws SQLException{
       int id = login();

       System.out.println("Enter your starting available date and time in the following format: yyyy-MM-dd hh:mm:ss.SSS");
       String timestampAsString1 = scan.next();

       System.out.println("Enter your ending available date and time in the following format: yyyy-MM-dd hh:mm:ss.SSS");
       String timestampAsString2 = scan.next();

       Timestamp timestamp1 = Timestamp.valueOf(timestampAsString1);
       Timestamp timestamp2 = Timestamp.valueOf(timestampAsString2);

       String action = "insert into cs320.availability(doctor_id, av_from, av_to) values (?, ?, ?)";
       PreparedStatement statement1 = myConn.prepareStatement(action);
       statement1.setInt(1, id);
       statement1.setTimestamp(2, timestamp1);
       statement1.setTimestamp(3, timestamp2);
       statement1.executeUpdate();

    }
    //A function that lets the doctors add diagnosis information for their patients
    public static void add_diagnosis() throws SQLException{
        int doctor_id=login();
        System.out.println("Enter the patient ID: ");
        int patient_id = scan.nextInt();
        System.out.println("Enter diagnosis: ");
        String diagnosis = scan.next();
        System.out.println("Enter the prescription: ");
        String medicine = scan.next();
        String action = "insert into cs320.diagnosis ('diagnosis', 'medicine', 'patient_id', 'doctor_id') values (?,?,?,?)";
        PreparedStatement statement1 = myConn.prepareStatement(action);
        statement1.setString(1,diagnosis);
        statement1.setString(2, medicine);
        statement1.setInt(3, patient_id);
        statement1.setInt(4, doctor_id);
        statement1.executeUpdate();
    }
    //A functions that lets the doctors add a meal plan for their patients
    public static void add_meal_plan() throws SQLException{
        System.out.println("Enter the patient ID: ");
        int patient_id = scan.nextInt();
        System.out.println("Enter breakfast plan: ");
        String breakfast = scan.next();
        System.out.println("Enter lunch plan: ");
        String lunch = scan.next();
        System.out.println("Enter dinner plan: ");
        String dinner = scan.next();
        String action = "insert into cs320.meal_plan ('breakfast', 'lunch', 'dinner', 'patient_id') values (?,?,?,?)";
        PreparedStatement statement1 = myConn.prepareStatement(action);
        statement1.setString(1, breakfast);
        statement1.setString(2, lunch);
        statement1.setString(3, dinner);
        statement1.setInt(4, patient_id);
        statement1.executeUpdate();
    }
    //A function that lets the doctors add an exercise plan for their patients
    public static void add_exercise_plan() throws SQLException{
        System.out.println("Enter the patient ID: ");
        int patient_id = scan.nextInt();
        System.out.println("Enter exercise plan: ");
        String plan = scan.next();
        String action = "insert into cs320.exercise_plan ('plan', 'patient_id') values (?, ?)";
        PreparedStatement statement1 = myConn.prepareStatement(action);
        statement1.setString(1, plan);
        statement1.setInt(2, patient_id);
        statement1.executeUpdate();
    }
    //The system login function for doctors
    public static int login() {
        System.out.println("Please enter your doctor id: ");
        int id = scan.nextInt();
        if (id == 1) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(doc_password1)) {
                doctor_id=1;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 2) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(doc_password2)) {
                doctor_id=2;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 3) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(doc_password3)) {
                doctor_id=3;
            }
            else{
                System.out.println("Invalid password!");
            }
        }
        else if (id == 4) {
            System.out.println("Please enter your password: ");
            String pass = scan.nextLine();
            if (pass.equals(doc_password4)) {
                doctor_id=4;
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

    }
