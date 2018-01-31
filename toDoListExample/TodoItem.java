package toDoListExample;

import java.util.Date;

public class TodoItem {	
	
	private String itemName;
	private Date startDate;
	private Date expiredDate;
	private String desc;
	private String status;
	
	public TodoItem(String itemName,Date startDate,Date expiredDate,String desc,String status){
		this.itemName = itemName;
		this.startDate = startDate;
		this.expiredDate = expiredDate;
		this.desc = desc;
		this.status = status;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
