package com.example.androiddevelopment.zadatakimenik.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Movie;

import com.example.androiddevelopment.zadatakimenik.db.model.Kontakti;
import com.example.androiddevelopment.zadatakimenik.db.model.Telefon;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by androiddevelopment on 20.3.17..
 */

public class ORMLightHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME    = "activities.db";
    private static final int    DATABASE_VERSION = 1;

    private Dao<Telefon, Integer> mTelefonDao = null;
    private Dao<Kontakti, Integer> mKontaktiDao = null;

    public ORMLightHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Telefon.class);
            TableUtils.createTable(connectionSource, Kontakti.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Telefon.class, true);
            TableUtils.dropTable(connectionSource, Kontakti.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<Telefon, Integer> getTelefonDao() throws SQLException {
        if (mTelefonDao == null) {
            mTelefonDao = getDao(Telefon.class);
        }

        return mTelefonDao;
    }

    public Dao<Kontakti, Integer> getKontaktiDao() throws SQLException {
        if (mKontaktiDao == null) {
            mKontaktiDao = getDao(Kontakti.class);
        }

        return mKontaktiDao;
    }

    //obavezno prilikom zatvarnaj rada sa bazom osloboditi resurse
    @Override
    public void close() {
        mTelefonDao = null;
        mKontaktiDao = null;

        super.close();
    }

}
