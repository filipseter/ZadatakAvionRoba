package zadaci;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.util.List;

public class Zadatak3IzmenaVrednosti {

    public static Dao<Avion, Integer> avionDao;
    public static Dao<Roba, Integer> robaDao;

    public static void main(String[] args) throws Exception {

        ConnectionSource cs = null;

        try {

            cs = new JdbcConnectionSource(Avion.DATABASE_URL);
            avionDao = DaoManager.createDao( cs, Avion.class );
            robaDao = DaoManager.createDao( cs, Roba.class );

            QueryBuilder<Roba, Integer> robaQB = robaDao.queryBuilder();
            robaQB.where().like(Roba.POLJE_OPIS, "%Plasticna stolica%");
            PreparedQuery<Roba> robaPQ = robaQB.prepare();
            List<Roba> robaList = robaDao.query( robaPQ );
            Avion.print_break();
            for (Roba roba : robaList )
                System.out.println( roba );
            Avion.print_break();
            Roba robaZaIzmenu = robaList.get(0);
            robaZaIzmenu.setOpis("Drvena stolica");

            robaDao.update( robaZaIzmenu );

            Avion.print_break();
            for (Roba roba : robaList )
                System.out.println( roba );
            Avion.print_break();

        } finally {
            if ( cs != null )
                cs.close();
        }

    }

}
