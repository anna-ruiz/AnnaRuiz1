package anna.ruiz.annaruiz1.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import anna.ruiz.annaruiz1.Configuraciones.configuracion;
import anna.ruiz.annaruiz1.Modelos.MemesItem;

public class MemeHelper extends OrmLiteSqliteOpenHelper {

    private Dao<MemesItem, String> daoMemes;

    public MemeHelper(Context context) {
        super(context, configuracion.BD_NOMBRE, null, configuracion.BD_VERSION);
    }
   public MemeHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    public Dao<MemesItem, String> getDaoMemes(){
        if (daoMemes == null){
            try {
                daoMemes = getDao(MemesItem.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return daoMemes;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, MemesItem.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
