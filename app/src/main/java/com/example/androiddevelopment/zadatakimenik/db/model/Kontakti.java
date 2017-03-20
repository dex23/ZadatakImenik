package com.example.androiddevelopment.zadatakimenik.db.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import static com.example.androiddevelopment.zadatakimenik.db.model.Kontakti.TABLE_TELEFON_ADDRESS;
import static com.example.androiddevelopment.zadatakimenik.db.model.Kontakti.TABLE_TELEFON_NAME;
import static com.example.androiddevelopment.zadatakimenik.db.model.Kontakti.TABLE_TELEFON_NUMBER;

/**
 * Created by androiddevelopment on 20.3.17..
 */

@DatabaseTable(tableName = Kontakti.TABLE_NAME_USERS)
public class Kontakti {
    public static final String TABLE_NAME_USERS = "kontakt";
    public static final String FIELD_NAME_ID = "id";
    public static final String TABLE_TELEFON_NAME = "name";
    public static final String TABLE_TELEFON_ADDRESS = "address";
    public static final String TABLE_TELEFON_NUMBER = "number";
    public static final String TABLE_TELEFON_TELEFON = "telefoni";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int tId;

    @DatabaseField(columnName = TABLE_TELEFON_NAME)
    private String tName;

    @DatabaseField(columnName = TABLE_TELEFON_ADDRESS)
    private String tAddress;

    @DatabaseField(columnName = TABLE_TELEFON_NUMBER)
    private String tNumber;

    @ForeignCollectionField(columnName = Kontakti.TABLE_TELEFON_TELEFON, eager = true)
    private ForeignCollection<Telefon> telefoni;

    public Kontakti() {
    }

    public int gettId() {
        return tId;
    }

    public String gettName() {
        return tName;
    }

    public String gettAddress() {
        return tAddress;
    }

    public String gettNumber() {
        return tNumber;
    }

    public ForeignCollection<Telefon> getTelefoni() {
        return telefoni;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public void setTelefoni(ForeignCollection<Telefon> telefoni) {
        this.telefoni = telefoni;
    }

    @Override
    public String toString() {
        return "Kontakti{" +
                "tId=" + tId +
                ", tName='" + tName + '\'' +
                ", tAddress='" + tAddress + '\'' +
                ", tNumber=" + tNumber +
                ", telefoni=" + telefoni +
                '}';
    }
}
