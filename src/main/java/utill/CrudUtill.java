package utill;

import Model.Customer;
import dbConnection.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class CrudUtill {
    public static <T> T execute(String sql,Object... args) throws SQLException {
        PreparedStatement psTM = DbConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            psTM.setObject((i+1),args[i]);
        }

        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) psTM.executeQuery();
        }

        return (T) (Boolean) (psTM.executeUpdate()>0);

    }

    public abstract boolean save(Customer customer) throws SQLException;

    public abstract boolean update(Object o);

    public abstract boolean delete(Object o);

    public abstract Object searchById(Object o) throws SQLException;

    public abstract List getAll() throws SQLException;

    public abstract Integer getCount();
}
