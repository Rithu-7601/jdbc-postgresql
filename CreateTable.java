package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) throws Exception {
        //Initialize jdbc driver
        Class.forName("org.postgresql.Driver");

        //connect to DB
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/edureka", "postgres", "root");
        System.out.println("<<<connected to postgresql db>>>");

        //Create an object for passing sql queries to connected db
        Statement st = con.createStatement();

        //pass the required sql queries to connected DB
        String sql = "CREATE TABLE EMP(EMPNO integer, ENAME VARCHAR(25), SALARY numeric(10,2), PRIMARY KEY(EMPNO))";
        try {
            st.execute(sql);
            System.out.println("Database table created!");
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.toString());
        }

        //close the connection
        st.close();
        con.close();
    }
}
