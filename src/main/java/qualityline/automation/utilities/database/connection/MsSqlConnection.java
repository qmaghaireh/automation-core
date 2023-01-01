package qualityline.automation.utilities.database.connection;

import qualityline.automation.utilities.database.DatabaseType;
import qualityline.automation.utilities.helpers.ConfigKey;
import qualityline.automation.utilities.helpers.config.CommonConfigReader;


/** @author Qasim Maghaireh */
public class MsSqlConnection extends DatabaseConnection {

  public MsSqlConnection() {
    super(DatabaseType.MSSQL);
  }

  @Override
  protected String getUrl() {
    return CommonConfigReader.getInstance().getPropValue(ConfigKey.MSSQL_DATABASE_URL);
  }

  @Override
  protected String getUsername() {
    return CommonConfigReader.getInstance().getPropValue(ConfigKey.MSSQL_DATABASE_USERNAME);
  }

  @Override
  protected String getPassword() {
    return CommonConfigReader.getInstance().getPropValue(ConfigKey.MSSQL_DATABASE_PASSWORD);
  }
}
