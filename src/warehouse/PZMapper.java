package warehouse;
import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

public class PZMapper implements RowMapper<PZ>{
	public PZ mapRow(ResultSet rs, int rowNum) throws SQLException{
		PZ pz = new PZ();
		
		pz.setID(rs.getInt("ID_PZ-HEADER"));
		pz.setNumber(rs.getInt("NUMBER"));
		pz.setDate(rs.getDate("DATE"));
		pz.setDetail(rs.getString("DETAILS"));
		pz.setSuma(rs.getDouble("SUMA"));
		pz.setID_ZZ(rs.getInt("ID_ZZ-HEADER"));
		
		return pz;
	}
}
