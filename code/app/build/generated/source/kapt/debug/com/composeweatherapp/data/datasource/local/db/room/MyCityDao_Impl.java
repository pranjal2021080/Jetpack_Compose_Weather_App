package com.composeweatherapp.data.datasource.local.db.room;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.composeweatherapp.data.datasource.local.db.entity.MyCityEntity;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class MyCityDao_Impl implements MyCityDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<MyCityEntity> __insertAdapterOfMyCityEntity;

  public MyCityDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfMyCityEntity = new EntityInsertAdapter<MyCityEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `my_city` (`id`,`temp`,`latitude`,`longitude`,`city`,`country`,`description`,`weather_image`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final MyCityEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getTemp());
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        if (entity.getCityName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getCityName());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getCountry());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getDescription());
        }
        statement.bindLong(8, entity.getWeatherImage());
      }
    };
  }

  @Override
  public Object addCity(final MyCityEntity myCityEntity,
      final Continuation<? super Unit> $completion) {
    if (myCityEntity == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfMyCityEntity.insert(_connection, myCityEntity);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public List<MyCityEntity> getMyCity() {
    final String _sql = "SELECT * FROM my_city";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTemp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfCityName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "city");
        final int _columnIndexOfCountry = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "country");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfWeatherImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "weather_image");
        final List<MyCityEntity> _result = new ArrayList<MyCityEntity>();
        while (_stmt.step()) {
          final MyCityEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final double _tmpTemp;
          _tmpTemp = _stmt.getDouble(_columnIndexOfTemp);
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpCityName;
          if (_stmt.isNull(_columnIndexOfCityName)) {
            _tmpCityName = null;
          } else {
            _tmpCityName = _stmt.getText(_columnIndexOfCityName);
          }
          final String _tmpCountry;
          if (_stmt.isNull(_columnIndexOfCountry)) {
            _tmpCountry = null;
          } else {
            _tmpCountry = _stmt.getText(_columnIndexOfCountry);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final int _tmpWeatherImage;
          _tmpWeatherImage = (int) (_stmt.getLong(_columnIndexOfWeatherImage));
          _item = new MyCityEntity(_tmpId,_tmpTemp,_tmpLatitude,_tmpLongitude,_tmpCityName,_tmpCountry,_tmpDescription,_tmpWeatherImage);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getSpecificCity(final String cityName,
      final Continuation<? super MyCityEntity> $completion) {
    final String _sql = "SELECT * FROM my_city WHERE city = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (cityName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, cityName);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTemp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfCityName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "city");
        final int _columnIndexOfCountry = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "country");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfWeatherImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "weather_image");
        final MyCityEntity _result;
        if (_stmt.step()) {
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final double _tmpTemp;
          _tmpTemp = _stmt.getDouble(_columnIndexOfTemp);
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpCityName;
          if (_stmt.isNull(_columnIndexOfCityName)) {
            _tmpCityName = null;
          } else {
            _tmpCityName = _stmt.getText(_columnIndexOfCityName);
          }
          final String _tmpCountry;
          if (_stmt.isNull(_columnIndexOfCountry)) {
            _tmpCountry = null;
          } else {
            _tmpCountry = _stmt.getText(_columnIndexOfCountry);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final int _tmpWeatherImage;
          _tmpWeatherImage = (int) (_stmt.getLong(_columnIndexOfWeatherImage));
          _result = new MyCityEntity(_tmpId,_tmpTemp,_tmpLatitude,_tmpLongitude,_tmpCityName,_tmpCountry,_tmpDescription,_tmpWeatherImage);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public void deleteMyCity(final String cityName) {
    final String _sql = "DELETE FROM my_city WHERE city = ?";
    DBUtil.performBlocking(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (cityName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, cityName);
        }
        _stmt.step();
        return null;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object updateMyCity(final double temp, final double latitude, final double longitude,
      final String cityName, final String description, final int weatherImage,
      final Continuation<? super Unit> $completion) {
    final String _sql = "UPDATE my_city SET `temp` = ?, latitude = ?, longitude = ?, description = ?, weather_image = ? WHERE city = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, temp);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, latitude);
        _argIndex = 3;
        _stmt.bindDouble(_argIndex, longitude);
        _argIndex = 4;
        if (description == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, description);
        }
        _argIndex = 5;
        _stmt.bindLong(_argIndex, weatherImage);
        _argIndex = 6;
        if (cityName == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, cityName);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
