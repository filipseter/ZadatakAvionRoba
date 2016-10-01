package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable( tableName = "avion" )
public class Avion {

    public static final String DATABASE_URL = "jdbc:sqlite:avionRoba.db";
    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_RASPON_KRILA = "raspon_krila";

    @DatabaseField( generatedId = true )
    private int id;
    @DatabaseField( columnName = POLJE_OZNAKA, canBeNull = false )
    private String oznaka;
    @DatabaseField( columnName = POLJE_RASPON_KRILA, canBeNull = false )
    private int rasponKrila;
    @ForeignCollectionField( foreignFieldName = "let" )
    ForeignCollection<Roba> roba;

    //GETTERS
    public int getId() { return id; }
    public String getOznaka() { return oznaka; }
    public int getRasponKrila() { return rasponKrila; }
    public ForeignCollection<Roba> getRoba() {
        return roba;
    }

    //SETTERS
    public void setOznaka( String oznaka ) {
        this.oznaka = oznaka;
    }
    public void setRasponKrila( int rasponKrila ) {
        this.rasponKrila = rasponKrila;
    }

    //CONSTRUCT
    public Avion( ) { }
    public Avion( String oznaka, int rasponKrila ) {
        this.oznaka = oznaka;
        this.rasponKrila = rasponKrila;
    }

    //TO_STRING
    @Override
    public String toString() {
        return "Avion { ID=" + id +
                ", OZNAKA=" + oznaka +
                ", RASPON_KRILA=" + rasponKrila +
                " }";
    }

}
