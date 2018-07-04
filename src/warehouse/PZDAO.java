package warehouse;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

public interface PZDAO {
	public void setDataSource(DataSource dataSource);
	public void create(Integer Number, Date Date, String Details, Double Suma, Integer ID_ZZ);
	public PZ getPZ(Integer ID_PZ);
	public List<PZ> listPZ();
	public void delete(Integer ID_PZ);
	public void update(Integer ID_PZ,Integer Number, Date Date, String Details, Double Suma,Integer ID_ZZ);
}
