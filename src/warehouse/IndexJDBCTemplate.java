package warehouse;

import java.util.*;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class IndexJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String Index, String Name, Double Price){
		String SQL = "insert into `Index` (`Index`, `Name`, Price) values (?,?,?)";
		jdbcTemplateObject.update(SQL, Index, Name, Price);
		//System.out.println("Created record with ID = ");
		return;
	}
	
	public Index getIndex(Integer ID_Index){
		String SQL = "select * from `Index` where id = " + ID_Index;
		Index index = jdbcTemplateObject.queryForObject(SQL, new Object[]{ID_Index}, new IndexMapper());
		
		return index;
	}
	
	public List<Index> listIndex(){
		String SQL = "Select * from `Index`";
		List <Index> index = jdbcTemplateObject.query(SQL, new IndexMapper());
		return index;
	}
	
	public void delete(Integer ID_Index){
		String SQL = "delete from `Index` where ID_Index = ?";
		jdbcTemplateObject.update(SQL, ID_Index);
		System.out.println("deleted from Index where id = " + ID_Index);  
		return;
	}
	
	public void update(Integer ID_Index, String Index, String Name, Double Price){
		String SQL = "update `Index` set `Index` = ?, `Name` = ?, Price =? where `ID_Index` = ?";
		jdbcTemplateObject.update(SQL, Index, Name, Price, ID_Index);
		System.out.println("Updated record with id = " + ID_Index);
		return;
	}
}
