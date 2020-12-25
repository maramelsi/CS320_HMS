
        import java.sql.*;
        import java.time.LocalDate;
        import java.util.Scanner;
        import java.time.*;
        public class Patient {

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
        static int user_id;
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

        public static void display_appointments() throws SQLException {
            int id = login();
            PreparedStatement statement1;
            String action = "SELECT * FROM cs320.appointment WHERE patient_id=?";
            statement1=myConn.prepareStatement(action);
            statement1.setInt(1,user_id);
            resultSet = statement1.executeQuery();
            while (resultSet.next()) {
                System.out.print("Appointment date= "+resultSet.getDate("ap_datetime"));
                System.out.print("  ");
                System.out.print("Doctor id= "+resultSet.getString("doctor_id"));
                System.out.print("  ");
                System.out.print("Polyclinic= "+resultSet.getString("polyclinic"));
                System.out.println("  ");
            }


        }

        public static void make_appointment() throws SQLException {
        int patient_id=login();
        PreparedStatement statement1;
        String action = "SELECT * FROM cs320.doctor";
        resultSet = statement.executeQuery(action);
        while (resultSet.next()) {
        System.out.print(resultSet.getInt("doctor_id"));
        System.out.print("  ");
        System.out.print(resultSet.getString("doctor_name"));
        System.out.print("  ");
        System.out.print(resultSet.getString("d_field"));
        System.out.println("  ");

        }
        System.out.println("Enter the doctor id of the doctor you want to make an appointment from: ");
        int doctor_id=scan.nextInt();
        if (doctor_id==1){
        String action1 = "INSERT INTO cs320.appointment(ap_datetime,patient_id,doctor_id,polyclinic) VALUES(?,?,?,?)";
        statement1 = myConn.prepareStatement(action1);
        statement1.setString(1, String.valueOf(LocalDate.now()));
        statement1.setInt(2, patient_id);
        statement1.setInt(3, doctor_id);
        statement1.setString(4,"cardiology" );
        statement1.executeUpdate();
        System.out.println("New appointment!");
        }
        else if (doctor_id==2){
        String action1 = "INSERT INTO cs320.appointment(ap_datetime,patient_id,doctor_id,polyclinic) VALUES(?,?,?,?)";
        statement1 = myConn.prepareStatement(action1);
        statement1.setString(1, String.valueOf(LocalDate.now()));
        statement1.setInt(2, patient_id);
        statement1.setInt(3, doctor_id);
        statement1.setString(4,"general surgery" );
        statement1.executeUpdate();
        System.out.println("New appointment!");
        }
        else if (doctor_id==3){
        String action1 = "INSERT INTO cs320.appointment(ap_datetime,patient_id,doctor_id,polyclinic) VALUES(?,?,?,?)";
        statement1 = myConn.prepareStatement(action1);
        statement1.setString(1, String.valueOf(LocalDate.now()));
        statement1.setInt(2, patient_id);
        statement1.setInt(3, doctor_id);
        statement1.setString(4,"ophthalmology" );
        statement1.executeUpdate();
        System.out.println("New appointment!");
        }
        else if (doctor_id==4){
        String action1 = "INSERT INTO cs320.appointment(ap_datetime,patient_id,doctor_id,polyclinic) VALUES(?,?,?,?)";
        statement1 = myConn.prepareStatement(action1);
        statement1.setString(1, String.valueOf(LocalDate.now()));
        statement1.setInt(2, patient_id);
        statement1.setInt(3, doctor_id);
        statement1.setString(4,"general practitionery" );
        statement1.executeUpdate();
        System.out.println("New appointment!");
        }
        else{
        System.out.println("Invalid doctor id!");
        }
        }
        public static void display_profile() throws SQLException {
        int id=login();
        PreparedStatement statement;
        String action = "SELECT * FROM cs320.patient WHERE patient_id= ? ";
        statement = myConn.prepareStatement(action);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
        System.out.print(resultSet.getInt("patient_id"));
        System.out.print("  ");
        System.out.print(resultSet.getString("patient_name"));
        System.out.print("  ");
        System.out.print(resultSet.getString("blood_type"));
        System.out.print("  ");
        System.out.print(resultSet.getString("p_weight"));
        System.out.print("    ");
        System.out.print(resultSet.getString("p_height"));
        System.out.print("  ");
        System.out.print(resultSet.getString("disease_hist"));
        System.out.print("  ");
        System.out.print(resultSet.getString("medicine_hist"));
        System.out.print("  ");
        System.out.print(resultSet.getString("diet_plan"));
        System.out.print("  ");
        System.out.print(resultSet.getString("exercise_plan"));
        System.out.println("  ");

        }
        }

        public static int login() {
        System.out.println("Please enter your patient id: ");
        int id = scan.nextInt();
        scan.nextLine();
        if (id == 1) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password1)) {
        user_id=1;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 2) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password2)) {
        user_id=2;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 3) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password3)) {
        user_id=3;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 4) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password4)) {
        user_id=4;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 5) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password5)) {
        user_id=5;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 6) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password6)) {
        user_id=6;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 7) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password7)) {
        user_id=7;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 8) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password8)) {
        user_id=8;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 9) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password9)) {
        user_id=9;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else if (id == 10) {
        System.out.println("Please enter your password: ");
        String pass = scan.nextLine();
        if (pass.equals(password10)) {
        user_id=10;
        }
        else{
        System.out.println("Invalid password!");
        }
        }
        else {
        System.out.println("Invalid user id!");
        }



        return user_id;

        }

        }


