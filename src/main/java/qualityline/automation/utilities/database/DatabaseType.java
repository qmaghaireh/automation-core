package qualityline.automation.utilities.database;

public enum DatabaseType {
  MYSQL("mysql", "com.mysql.jdbc.Driver", "jdbc:mysql://"),
  MSSQL("sql", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver:"),
  MONGO("mongo", "mongodb.jdbc.MongoDriver", "jdbc:mongo://"),
  ORACLE("oracle", "oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:");

  private final String name;
  private final String driver;
  private final String prefix;

  DatabaseType(String name, String driver, String prefix) {
    this.name = name;
    this.driver = driver;
    this.prefix = prefix;
  }

  public static DatabaseType fromString(String type) {
    for (DatabaseType dbType : values()) {
      if (dbType.getName().equals(type)) {
        return dbType;
      }
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public String getDriver() {
    return driver;
  }

  public String getPrefix() {
    return prefix;
  }
}
