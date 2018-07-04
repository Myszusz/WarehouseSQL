package warehouse;
import java.sql.Date;

public class PZ {
	private Integer ID_PZ;
	private Integer Number;
	private Date Date;
	private String Details;
	private Double Suma;
	private Integer ID_ZZ;
	
	public Integer getID(){
		return ID_PZ;
	}
	
	public void setID(Integer ID_PZ){
		this.ID_PZ = ID_PZ;
	}
	
	public Integer getNumber(){
		return Number;
	}
	
	public void setNumber(Integer Number){
		this.Number = Number;
	}
	
	public Date getDate(){
		return Date;
	}
	
	public void setDate(Date Date){
		this.Date = Date;
	}
	
	public String getDeatails(){
		return Details;
	}
	
	public void setDetail(String Details){
		this.Details = Details;
	}
	
	public Double getSuma(){
		return Suma;
	}
	
	public void setSuma(Double Suma){
		this.Suma = Suma;
	}
	
	public Integer getID_ZZ(){
		return ID_ZZ;
	}
	
	public void setID_ZZ(Integer ID_ZZ){
		this.ID_ZZ = ID_ZZ;
	}
	
	public Object[] getArray(){
		Object[] PZArr = new Object[6];
		PZArr[0] = ID_PZ;
		PZArr[1] = Number;
		PZArr[2] = Date;
		PZArr[3] = Details;
		PZArr[4] = Suma;
		PZArr[5] = ID_ZZ;
		return PZArr;
	}
}
