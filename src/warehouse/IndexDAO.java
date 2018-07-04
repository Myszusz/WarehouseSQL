package warehouse;
import java.util.*;
import javax.sql.*;

public interface IndexDAO {

	public void setDataSource(DataSource ds);
	public void create(Integer ID_Index, String Index, String Name, Double Price);
	public Index getIndex(Integer ID_Index);
	public List<Index> listIndex();
	public void delete(Integer ID_Index);
	public void update(Integer ID_Index, String Index, String Name, Double Price);
}
