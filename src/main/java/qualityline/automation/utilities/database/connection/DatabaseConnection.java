package qualityline.automation.utilities.database.connection;

import qualityline.automation.utilities.database.DatabaseType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** @author Qasim Maghaireh */
public abstract class DatabaseConnection {

  private final DatabaseType type;
  private Connection connection;

  public DatabaseConnection(DatabaseType type) {
    this.type = type;
    createConnection();
  }

  private void createConnection() {
    try {
      Class.forName(type.getDriver());
      connection =
          DriverManager.getConnection(
              type.getPrefix().concat(getUrl()), getUsername(), getPassword());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  protected abstract String getUrl();

  protected abstract String getUsername();

  protected abstract String getPassword();

  public Connection getConnection() {
    return connection;
  }

  public void closeConnection() {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
      }
      connection = null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
