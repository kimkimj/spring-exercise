import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStrategy implements StatementStrategy{
    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("insert into users (id, name, password) value(?,?,?)");
        return null;
    }
}
