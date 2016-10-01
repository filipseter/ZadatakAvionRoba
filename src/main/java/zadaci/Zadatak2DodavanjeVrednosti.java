package zadaci;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.util.List;

public class Zadatak2DodavanjeVrednosti {

    public static Dao<Avion, Integer> avionDao;
    public static Dao<Roba, Integer> robaDao;

    public static void main(String[] args) throws Exception {

        ConnectionSource cs = null;

        try {

            cs = new JdbcConnectionSource(Avion.DATABASE_URL);
            avionDao = DaoManager.createDao( cs, Avion.class );
            robaDao = DaoManager.createDao( cs, Roba.class );
            TableUtils.clearTable( cs, Avion.class );
            TableUtils.clearTable( cs, Roba. class );

            Avion avion1 = new Avion( "Avion1", 34 );
            avionDao.create( avion1 );
            Avion avion2 = new Avion( "Avion2", 21 );
            avionDao.create( avion2 );
            Roba roba1 = new Roba( "Patike", "Duboke patike", 1, 0.1, 0.4, 0.05, avion1 );
            robaDao.create( roba1 );
            Roba roba2 = new Roba( "Kosulja", "Na duge rukave", 0.4, 0.01, 2.4, 0.5, avion1 );
            robaDao.create( roba2 );
            Roba roba3 = new Roba( "Voda", "Voda za pice", 1.4, 0.3, 0.04, 0.03, avion1 );
            robaDao.create( roba3 );
            Roba roba4 = new Roba( "Ploce", "Drvene ploce", 3.4, 0.1, 3, 2.3, avion2 );
            robaDao.create( roba4 );
            Roba roba5 = new Roba( "Stolica", "Plasticna stolica", 2.4, 1.2, 0.8, 0.5, avion2 );
            robaDao.create( roba5 );

            List<Avion> avionList = avionDao.queryForAll();
            Avion.print_break();
            for (Avion avion: avionList ) {
                System.out.println( avion );
            }
            List<Roba> robaList = robaDao.queryForAll();
            Avion.print_break();
            for (Roba roba: robaList ) {
                System.out.println( roba );
            }
            Avion.print_break();

        } finally {
            if ( cs != null )
                cs.close();
        }

    }

}
