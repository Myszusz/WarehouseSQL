package warehouse;

import java.sql.*;
import org.springframework.jdbc.core.RowMapper;

public class IndexMapper implements RowMapper<Index> {
	public Index mapRow(ResultSet rs, int rowNum) throws SQLException{
		Index index = new Index();
		
		index.setID(rs.getInt("ID_Index"));
		index.setIndex(rs.getString("Index"));
		index.setName(rs.getString("Name"));
		index.setPrice(rs.getDouble("Price"));
		
		return index;
	}
}
