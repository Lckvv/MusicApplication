package com.music.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.music.database.models.Band;
import com.music.utils.exceptions.ApplicationException;

import java.sql.SQLException;

public class BandDao extends ControllerDao {
    public BandDao() {super();
    }

    public void deleteByColumnName(String columName, int id) throws ApplicationException, SQLException {
        Dao<Band, Object> dao = getDao(Band.class);
        DeleteBuilder<Band, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columName, id);
        dao.delete(deleteBuilder.prepare());
    }
}
