package qualityline.automation.utilities.database;

import qualityline.automation.utilities.database.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** @author Qasim Maghaireh */
public class DatabaseCrud {

  private final Connection connection;

  public DatabaseCrud(DatabaseConnection connection) {
    this.connection = connection.getConnection();
  }

  public ResultSet create(String query) throws SQLException {
    Statement statement = connection.createStatement();
    return statement.executeQuery(query);
  }

  public ResultSet read(String query) throws SQLException {
    Statement statement = connection.createStatement();
    statement.execute(query);
    return statement.getResultSet();
  }

  public List<String> readByColumnName(String columnName, String query) throws SQLException {
    List<String> result = new ArrayList<>();
    ResultSet resultSet = read(query);
    while (resultSet.next()) {
      result.add(resultSet.getString(columnName));
    }
    return result;
  }

  public List<String> readByColumnIndex(int columnIndex, String query) throws SQLException {
    List<String> result = new ArrayList<>();
    ResultSet resultSet = read(query);
    while (resultSet.next()) {
      result.add(resultSet.getString(columnIndex));
    }
    return result;
  }

  public long update(String query) throws SQLException {
    Statement statement = connection.createStatement();
    return statement.executeUpdate(query);
  }

  public void delete(String query) throws SQLException {
    Statement statement = connection.createStatement();
    statement.execute(query);
  }
}
