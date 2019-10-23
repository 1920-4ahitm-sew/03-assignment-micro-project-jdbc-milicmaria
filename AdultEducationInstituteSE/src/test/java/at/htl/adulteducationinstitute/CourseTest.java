package at.htl.adulteducationinstitute;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;

public class CourseTest {

    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection conn;

    @BeforeEach
    public static void initJdbc(){
        try {
            Class.forName(DRIVER_STRING);
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("Verbindung zur Datenbank nicht möglich: \n"
                + e.getMessage() + "\n");
            System.exit(1);
        }
    }

    @AfterEach
    public static void teardownJdbc() {
        try {
            if (conn!= null|| !conn.isClosed()){
                conn.close();
                System.out.println("Goodbye!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void firstTest(){
        fail();
    }

    @Test
    public void dml() throws SQLException {
        int countInserts = 0;

        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO course(id, courseName, amountBookings) value (1, 'Englisch für Anfänger', 25)";
            countInserts += stmt.executeUpdate(sql);
            sql = "INSERT INTO course(id, courseName, amountBookings) value (2, 'Deutsch B1', 17)";
            countInserts += stmt.executeUpdate(sql);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        assertThat(countInserts, is(2));

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, courseName, amountBookings from course");
            ResultSet rset = pstmt.executeQuery();

            rset.next();
            assertThat(rset.getString("courseName"), is("Englisch für Anfänger"));
            assertThat(rset.getString("amountBookings"), is(25));

            rset.next();
            assertThat(rset.getString("courseName"), is("Deutsch B1"));
            assertThat(rset.getString("amountBookings"), is(17));

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
