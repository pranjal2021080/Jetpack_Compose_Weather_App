package com.composeweatherapp.data.datasource.local.db.room;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.composeweatherapp.data.datasource.local.db.entity.CityEntity;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class CityDao_Impl implements CityDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<CityEntity> __insertAdapterOfCityEntity;

  private final EntityDeleteOrUpdateAdapter<CityEntity> __updateAdapterOfCityEntity;

  public CityDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfCityEntity = new EntityInsertAdapter<CityEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `city_data` (`id`,`country`,`timezone`,`sunrise`,`sunset`,`city_name`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final CityEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCountry() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getCountry());
        }
        statement.bindLong(3, entity.getTimezone());
        statement.bindLong(4, entity.getSunrise());
        statement.bindLong(5, entity.getSunset());
        if (entity.getCityName() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getCityName());
        }
        statement.bindDouble(7, entity.getLatitude());
        statement.bindDouble(8, entity.getLongitude());
      }
    };
    this.__updateAdapterOfCityEntity = new EntityDeleteOrUpdateAdapter<CityEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR REPLACE `city_data` SET `id` = ?,`country` = ?,`timezone` = ?,`sunrise` = ?,`sunset` = ?,`city_name` = ?,`latitude` = ?,`longitude` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final CityEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCountry() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getCountry());
        }
        statement.bindLong(3, entity.getTimezone());
        statement.bindLong(4, entity.getSunrise());
        statement.bindLong(5, entity.getSunset());
        if (entity.getCityName() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getCityName());
        }
        statement.bindDouble(7, entity.getLatitude());
        statement.bindDouble(8, entity.getLongitude());
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public Object addCity(final CityEntity cityEntity, final Continuation<? super Unit> $completion) {
    if (cityEntity == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfCityEntity.insert(_connection, cityEntity);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object updateCity(final CityEntity cityEntity,
      final Continuation<? super Unit> $completion) {
    if (cityEntity == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfCityEntity.handle(_connection, cityEntity);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public CityEntity getCity() {
    final String _sql = "SELECT * FROM city_data";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfCountry = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "country");
        final int _columnIndexOfTimezone = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timezone");
        final int _columnIndexOfSunrise = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sunrise");
        final int _columnIndexOfSunset = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sunset");
        final int _columnIndexOfCityName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "city_name");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final CityEntity _result;
        if (_stmt.step()) {
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpCountry;
          if (_stmt.isNull(_columnIndexOfCountry)) {
            _tmpCountry = null;
          } else {
            _tmpCountry = _stmt.getText(_columnIndexOfCountry);
          }
          final int _tmpTimezone;
          _tmpTimezone = (int) (_stmt.getLong(_columnIndexOfTimezone));
          final long _tmpSunrise;
          _tmpSunrise = _stmt.getLong(_columnIndexOfSunrise);
          final long _tmpSunset;
          _tmpSunset = _stmt.getLong(_columnIndexOfSunset);
          final String _tmpCityName;
          if (_stmt.isNull(_columnIndexOfCityName)) {
            _tmpCityName = null;
          } else {
            _tmpCityName = _stmt.getText(_columnIndexOfCityName);
          }
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          _result = new CityEntity(_tmpId,_tmpCountry,_tmpTimezone,_tmpSunrise,_tmpSunset,_tmpCityName,_tmpLatitude,_tmpLongitude);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
