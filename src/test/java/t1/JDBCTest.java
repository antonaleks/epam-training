package t1;

import static lombok.AccessLevel.PRIVATE;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.junit.Test;

@FieldDefaults(level = PRIVATE)
public class JDBCTest {

    String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

    String CREATE_TABLE_SQL = "create table students (id identity, name varchar not null, group_id int)";
    String INSERT_STUDENT_SQL = "insert into students (name, group_id) values (?, ?)";
    String GET_STUDENTS_SQL = "select id, name, group_id from students";
    String DELETE_TABLE_SQL = "drop table students";
    String GET_STUDENTS_WITH_NAME_SQL = "select id, name, group_id from students where name=?";
    String UPDATE_STUDENT_SQL = "update students set name = 'NoName' where id = ?";

    String ID_FIELD = "id";
    String NAME_FIELD = "name";
    String GROUP_ID_FIELD = "group_id";

    String[] names = {"Антон", "Лена", "МистерПропер"};

    @Test
    @SneakyThrows
    public void testJdbc() {

        @Cleanup val connection = DriverManager.getConnection(DB_URL);
        @Cleanup val statement = connection.createStatement();
        statement.executeUpdate(CREATE_TABLE_SQL);
        @Cleanup PreparedStatement prepStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
        for (String name : names) {
            prepStatement.setString(1, name);
            prepStatement.setInt(2, 24);
            prepStatement.execute();
        }
        @Cleanup val resultSet = statement.executeQuery(GET_STUDENTS_SQL);
        getInfoByPrepareStatement(resultSet);
        prepStatement = connection.prepareStatement(GET_STUDENTS_WITH_NAME_SQL);
        prepStatement.setString(1, "Лена");
        @Cleanup val resultSetWithName = prepStatement.executeQuery();
        getInfoByPrepareStatement(resultSetWithName);
        @Cleanup PreparedStatement prepStatementUpdate = connection
            .prepareStatement(UPDATE_STUDENT_SQL);
        for (int i = 1; i < 3; i++) {
            prepStatementUpdate.setInt(1, i);
            prepStatementUpdate.executeUpdate();
        }
        getInfoByPrepareStatement(statement.executeQuery(GET_STUDENTS_SQL));
        statement.executeUpdate(DELETE_TABLE_SQL);


    }

    @SneakyThrows
    public void getInfoByPrepareStatement(ResultSet resultSet) {
        while (resultSet.next()) {
            System.out.printf("%d %s %d%n",
                resultSet.getInt(ID_FIELD),
                resultSet.getString(NAME_FIELD),
                resultSet.getInt(GROUP_ID_FIELD));
        }
    }


}
