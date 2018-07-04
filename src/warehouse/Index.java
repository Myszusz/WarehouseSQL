package warehouse;

public class Index {
	private Integer ID_Index;
	private String Index;
	private String Name;
	private Double Price;
	
	public Integer getID(){
		return ID_Index;
	}
	
	public void setID(Integer ID_Index){
		this.ID_Index = ID_Index;
	}
	
	public void setIndex(String Index){
		this.Index = Index;
	}
	
	public String getIndex(){
		return Index;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setPrice(Double Price){
		this.Price = Price;
	}
	
	public Double getPrice(){
		return Price;
	}
	
	public Object[] getArray(){
		Object[] indexArr = new Object[4];
		indexArr[0] = ID_Index;
		indexArr[1] = Index;
		indexArr[2] = Name;
		indexArr[3] = Price;
		return indexArr;
	}
}
