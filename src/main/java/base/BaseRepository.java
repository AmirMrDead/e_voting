package base;

import java.sql.SQLException;

public interface BaseRepository<T> {
    void save(T t) throws SQLException;

    T load(T t) throws SQLException;

    void update(T t , int id)throws SQLException;

    void delete(T t)throws SQLException;

}
