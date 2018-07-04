package warehouse;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class PZJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(Integer Number, String Details, Double Suma){
		String SQL = "insert into `PZ-HEADER` (`Number`, `Details`, `Suma`) values (?,?,?)";
		jdbcTemplateObject.update(SQL,Number,Details,Suma);
		return;
	}
	
	public PZ getPZ(Integer ID_PZ){
		String SQL = "select * from `PZ-HEADER` where id = " + ID_PZ;
		PZ pz = jdbcTemplateObject.queryForObject(SQL, new Object[]{ID_PZ}, new PZMapper());
		
		return pz;
	}
	
	public List<PZ> listPZ(){
		String SQL = "Select * from `PZ-HEADER`";
		List <PZ> pz = jdbcTemplateObject.query(SQL, new PZMapper());
		return pz;
	}
	
	public void delete(Integer ID_PZ){
		String SQL = "delete from `PZ-HEADER` where ID_PZ-HEADER = ?";
		jdbcTemplateObject.update(SQL, ID_PZ);
		return;
	}
	
	public void update(Integer ID_PZ,Integer Number, String Details, Double Suma){
		String SQL = "update `PZ-HEADER` set `NUMBER` = ?, `DETAILS` =?, `SUMA` =? where `ID_Index` = ?";
		jdbcTemplateObject.update(SQL, Number, Details, Suma);
		return;
	}
}
