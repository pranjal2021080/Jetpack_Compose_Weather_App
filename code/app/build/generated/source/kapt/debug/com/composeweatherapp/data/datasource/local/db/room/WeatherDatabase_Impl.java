package com.composeweatherapp.data.datasource.local.db.room;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class WeatherDatabase_Impl extends WeatherDatabase {
  private volatile CityDao _cityDao;

  private volatile ForecastDao _forecastDao;

  private volatile MyCityDao _myCityDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "575266f8cf4a60e0996c32a0dc80833d", "c8a181182df33e0cabebea22a07062b4") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `city_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `country` TEXT NOT NULL, `timezone` INTEGER NOT NULL, `sunrise` INTEGER NOT NULL, `sunset` INTEGER NOT NULL, `city_name` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `forecast_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `temp` REAL NOT NULL, `feels_like` REAL NOT NULL, `pressure` REAL NOT NULL, `humidity` INTEGER NOT NULL, `speed` REAL NOT NULL, `description` TEXT NOT NULL, `main_description` TEXT NOT NULL, `date` TEXT NOT NULL, `cloudinessDto` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `my_city` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `temp` REAL NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `description` TEXT NOT NULL, `weather_image` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '575266f8cf4a60e0996c32a0dc80833d')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `city_data`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `forecast_data`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `my_city`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsCityData = new HashMap<String, TableInfo.Column>(8);
        _columnsCityData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("timezone", new TableInfo.Column("timezone", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("sunrise", new TableInfo.Column("sunrise", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("sunset", new TableInfo.Column("sunset", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("city_name", new TableInfo.Column("city_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCityData.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysCityData = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesCityData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCityData = new TableInfo("city_data", _columnsCityData, _foreignKeysCityData, _indicesCityData);
        final TableInfo _existingCityData = TableInfo.read(connection, "city_data");
        if (!_infoCityData.equals(_existingCityData)) {
          return new RoomOpenDelegate.ValidationResult(false, "city_data(com.composeweatherapp.data.datasource.local.db.entity.CityEntity).\n"
                  + " Expected:\n" + _infoCityData + "\n"
                  + " Found:\n" + _existingCityData);
        }
        final Map<String, TableInfo.Column> _columnsForecastData = new HashMap<String, TableInfo.Column>(10);
        _columnsForecastData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("temp", new TableInfo.Column("temp", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("feels_like", new TableInfo.Column("feels_like", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("pressure", new TableInfo.Column("pressure", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("humidity", new TableInfo.Column("humidity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("speed", new TableInfo.Column("speed", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("main_description", new TableInfo.Column("main_description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsForecastData.put("cloudinessDto", new TableInfo.Column("cloudinessDto", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysForecastData = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesForecastData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoForecastData = new TableInfo("forecast_data", _columnsForecastData, _foreignKeysForecastData, _indicesForecastData);
        final TableInfo _existingForecastData = TableInfo.read(connection, "forecast_data");
        if (!_infoForecastData.equals(_existingForecastData)) {
          return new RoomOpenDelegate.ValidationResult(false, "forecast_data(com.composeweatherapp.data.datasource.local.db.entity.ForecastEntity).\n"
                  + " Expected:\n" + _infoForecastData + "\n"
                  + " Found:\n" + _existingForecastData);
        }
        final Map<String, TableInfo.Column> _columnsMyCity = new HashMap<String, TableInfo.Column>(8);
        _columnsMyCity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("temp", new TableInfo.Column("temp", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyCity.put("weather_image", new TableInfo.Column("weather_image", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysMyCity = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesMyCity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMyCity = new TableInfo("my_city", _columnsMyCity, _foreignKeysMyCity, _indicesMyCity);
        final TableInfo _existingMyCity = TableInfo.read(connection, "my_city");
        if (!_infoMyCity.equals(_existingMyCity)) {
          return new RoomOpenDelegate.ValidationResult(false, "my_city(com.composeweatherapp.data.datasource.local.db.entity.MyCityEntity).\n"
                  + " Expected:\n" + _infoMyCity + "\n"
                  + " Found:\n" + _existingMyCity);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "city_data", "forecast_data", "my_city");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "city_data", "forecast_data", "my_city");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CityDao.class, CityDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ForecastDao.class, ForecastDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MyCityDao.class, MyCityDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CityDao cityDao() {
    if (_cityDao != null) {
      return _cityDao;
    } else {
      synchronized(this) {
        if(_cityDao == null) {
          _cityDao = new CityDao_Impl(this);
        }
        return _cityDao;
      }
    }
  }

  @Override
  public ForecastDao forecastWeatherDao() {
    if (_forecastDao != null) {
      return _forecastDao;
    } else {
      synchronized(this) {
        if(_forecastDao == null) {
          _forecastDao = new ForecastDao_Impl(this);
        }
        return _forecastDao;
      }
    }
  }

  @Override
  public MyCityDao myCityDao() {
    if (_myCityDao != null) {
      return _myCityDao;
    } else {
      synchronized(this) {
        if(_myCityDao == null) {
          _myCityDao = new MyCityDao_Impl(this);
        }
        return _myCityDao;
      }
    }
  }
}
