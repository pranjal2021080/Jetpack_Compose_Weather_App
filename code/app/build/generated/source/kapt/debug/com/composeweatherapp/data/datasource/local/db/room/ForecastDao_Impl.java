package com.composeweatherapp.data.datasource.local.db.room;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.composeweatherapp.data.datasource.local.db.entity.ForecastEntity;
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
public final class ForecastDao_Impl implements ForecastDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<ForecastEntity> __insertAdapterOfForecastEntity;

  private final EntityDeleteOrUpdateAdapter<ForecastEntity> __updateAdapterOfForecastEntity;

  public ForecastDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfForecastEntity = new EntityInsertAdapter<ForecastEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `forecast_data` (`id`,`temp`,`feels_like`,`pressure`,`humidity`,`speed`,`description`,`main_description`,`date`,`cloudinessDto`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final ForecastEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getTemp());
        statement.bindDouble(3, entity.getFeels_like());
        statement.bindDouble(4, entity.getPressure());
        statement.bindLong(5, entity.getHumidity());
        statement.bindDouble(6, entity.getWind_speed());
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getDescription());
        }
        if (entity.getMainDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getMainDescription());
        }
        if (entity.getDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindText(9, entity.getDate());
        }
        statement.bindLong(10, entity.getCloudiness());
      }
    };
    this.__updateAdapterOfForecastEntity = new EntityDeleteOrUpdateAdapter<ForecastEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR REPLACE `forecast_data` SET `id` = ?,`temp` = ?,`feels_like` = ?,`pressure` = ?,`humidity` = ?,`speed` = ?,`description` = ?,`main_description` = ?,`date` = ?,`cloudinessDto` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final ForecastEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getTemp());
        statement.bindDouble(3, entity.getFeels_like());
        statement.bindDouble(4, entity.getPressure());
        statement.bindLong(5, entity.getHumidity());
        statement.bindDouble(6, entity.getWind_speed());
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getDescription());
        }
        if (entity.getMainDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getMainDescription());
        }
        if (entity.getDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindText(9, entity.getDate());
        }
        statement.bindLong(10, entity.getCloudiness());
        statement.bindLong(11, entity.getId());
      }
    };
  }

  @Override
  public Object addForecastWeather(final ForecastEntity forecastEntity,
      final Continuation<? super Unit> $completion) {
    if (forecastEntity == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfForecastEntity.insert(_connection, forecastEntity);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object updateForecastWeather(final ForecastEntity forecastEntity,
      final Continuation<? super Unit> $completion) {
    if (forecastEntity == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfForecastEntity.handle(_connection, forecastEntity);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public List<ForecastEntity> getForecastWeather() {
    final String _sql = "SELECT * FROM forecast_data";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTemp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "temp");
        final int _columnIndexOfFeelsLike = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "feels_like");
        final int _columnIndexOfPressure = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "pressure");
        final int _columnIndexOfHumidity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "humidity");
        final int _columnIndexOfWindSpeed = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "speed");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfMainDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "main_description");
        final int _columnIndexOfDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "date");
        final int _columnIndexOfCloudiness = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "cloudinessDto");
        final List<ForecastEntity> _result = new ArrayList<ForecastEntity>();
        while (_stmt.step()) {
          final ForecastEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final double _tmpTemp;
          _tmpTemp = _stmt.getDouble(_columnIndexOfTemp);
          final double _tmpFeels_like;
          _tmpFeels_like = _stmt.getDouble(_columnIndexOfFeelsLike);
          final double _tmpPressure;
          _tmpPressure = _stmt.getDouble(_columnIndexOfPressure);
          final int _tmpHumidity;
          _tmpHumidity = (int) (_stmt.getLong(_columnIndexOfHumidity));
          final double _tmpWind_speed;
          _tmpWind_speed = _stmt.getDouble(_columnIndexOfWindSpeed);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpMainDescription;
          if (_stmt.isNull(_columnIndexOfMainDescription)) {
            _tmpMainDescription = null;
          } else {
            _tmpMainDescription = _stmt.getText(_columnIndexOfMainDescription);
          }
          final String _tmpDate;
          if (_stmt.isNull(_columnIndexOfDate)) {
            _tmpDate = null;
          } else {
            _tmpDate = _stmt.getText(_columnIndexOfDate);
          }
          final int _tmpCloudiness;
          _tmpCloudiness = (int) (_stmt.getLong(_columnIndexOfCloudiness));
          _item = new ForecastEntity(_tmpId,_tmpTemp,_tmpFeels_like,_tmpPressure,_tmpHumidity,_tmpWind_speed,_tmpDescription,_tmpMainDescription,_tmpDate,_tmpCloudiness);
          _result.add(_item);
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
