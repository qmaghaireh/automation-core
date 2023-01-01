package qualityline.automation.utilities.helpers;

public enum ConfigKey {
  BASE_URL("base.url"),
  APPIUM_URL("appium.server.url"),
  PLATFORM_NAME("platform.name"),
  MYSQL_DATABASE_URL("mysql.database.url"),
  MYSQL_DATABASE_USERNAME("mysql.database.username"),
  MYSQL_DATABASE_PASSWORD("mysql.database.password"),
  ORACLE_DATABASE_URL("oracle.database.url"),
  ORACLE_DATABASE_USERNAME("oracle.database.username"),
  ORACLE_DATABASE_PASSWORD("oracle.database.password"),
  MONGO_DATABASE_URL("mongo.database.url"),
  MONGO_DATABASE_USERNAME("mongo.database.username"),
  MONGO_DATABASE_PASSWORD("mongo.database.password"),
  MSSQL_DATABASE_URL("mssql.database.url"),
  MSSQL_DATABASE_USERNAME("mssql.database.username"),
  MSSQL_DATABASE_PASSWORD("mssql.database.password");

  private final String key;

  ConfigKey(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
