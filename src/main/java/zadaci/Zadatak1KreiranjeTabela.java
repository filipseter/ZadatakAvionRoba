package zadaci;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

public class Zadatak1KreiranjeTabela {

    public static Dao<Avion, Integer> avionDao;
    public static Dao<Roba, Integer> robaDao;

    public static void main(String[] args) throws Exception {

        ConnectionSource cs = null;

        try {

            cs = new JdbcConnectionSource(Avion.DATABASE_URL);
            avionDao = DaoManager.createDao( cs, Avion.class );
            robaDao = DaoManager.createDao( cs, Roba.class );
            TableUtils.dropTable( cs, Avion.class, true );
            TableUtils.dropTable( cs, Roba.class, true );
            TableUtils.createTable( cs, Avion.class );
            TableUtils.createTable( cs, Roba.class );


        } finally {
            if ( cs != null )
                cs.close();
        }

    }

}
