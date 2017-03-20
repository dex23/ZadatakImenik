package com.example.androiddevelopment.zadatakimenik.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import static com.example.androiddevelopment.zadatakimenik.db.model.Kontakti.TABLE_TELEFON_NAME;
import static com.example.androiddevelopment.zadatakimenik.db.model.Telefon.FIELD_NAME_ID;
import static com.example.androiddevelopment.zadatakimenik.db.model.Telefon.FIELD_NAME_USER;

/**
 * Created by androiddevelopment on 20.3.17..
 */

@DatabaseTable(tableName = Telefon.TABLE_NAME_USERS)
public class Telefon {

    public static final String TABLE_NAME_USERS = "telefon";
    public static final String FIELD_NAME_ID     = "id";
    public static final String TABLE_TELEFON_HOME    = "kucni";
    public static final String TABLE_TELEFON_MOBILE    = "mobilni";
    public static final String TABLE_TELEFON_WORK   = "poslovni";
    public static final String FIELD_NAME_USER  = "user";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int tId;

    @DatabaseField(columnName = TABLE_TELEFON_NAME)
    private String tName;

    @DatabaseField(columnName = TABLE_TELEFON_HOME)
    private String tHome;

    @DatabaseField(columnName = TABLE_TELEFON_MOBILE)
    private String tMobile;

    @DatabaseField(columnName = TABLE_TELEFON_WORK)
    private String tWork;

    @DatabaseField(columnName = FIELD_NAME_USER, foreign = true, foreignAutoRefresh = true)
    private Kontakti tUser;


}
