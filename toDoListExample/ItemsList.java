package toDoListExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ItemsList {
	
	public List<TodoItem> itemsList = new ArrayList<TodoItem>();

    public void chooseOperations() {
		
		System.out.println("Track your todolist:");
		System.out.println("********************\n");

		
        Map<Integer,String> map = loadOperations();		
		
		for (Map.Entry<Integer, String> entry : map.entrySet()){
		    System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("********************\n");
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter your choice number:\n");		
		int selectedOperation = scanner.nextInt();
		executeOperation(selectedOperation);		
		
	}
	
	

	public void executeOperation(int selectedOperation) {
		switch(selectedOperation){
		  case 1: addItem();
		          break;
		  case 2: deleteItem();
                  break;
		  case 3: editItem();
                  break;
		  case 4: checkDeadline();
                  break;
		  case 5: remove_done_expired();
                  break;
		  case 6: getDesc();
                  break;
		  case 7: searchItem();
                  break;          
		  case 8: getAllItems();
                  break;  
		  case 9: System.out.println("\nExit Program");		
			      return;
		  
          default:
        	      System.out.println("Invalid Operation");
        	      chooseOperations();
		}
	}	
	
	public void addItem() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter todo Item name:\n");
		String todoItem = scanner.next();
		
		System.out.println("Enter start date(ex: 1-Jan-2017):\n");
		String startDate = scanner.next();
		Date stDate= DateUtil.stringToDate(startDate);
		
		System.out.println("Enter end date(ex: 10-Feb-2017):\n");
		String expiredDate = scanner.next();
		Date exDate=  DateUtil.stringToDate(expiredDate);
		
		System.out.println("Enter description:");
		String desc = scanner.next();
		String status = ItemStatus.IN_PROGRESS.toString();

		itemsList.add(new TodoItem(todoItem,stDate,exDate,desc,status));
		System.out.println("\nSuccessfully added "+todoItem+" item !!!");
		
		System.out.println("\nDo you want to add one more todo Item (Yes/No):\n");
		String oneMore = scanner.next();
		if("yes".equalsIgnoreCase(oneMore.toLowerCase())) {
			addItem();
		} else {
			chooseOperations();
		} 	
		
	}
	
	
	
	public void deleteItem() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter todo Item name:\n");
		String deleteItem = scanner.next();
		
		if(deleteItem!=null){
			if(itemsList!=null && !itemsList.isEmpty()){
				for (TodoItem item : itemsList){
				     if(item!=null && item.getItemName().equals(deleteItem)){
				    	 itemsList.remove(item);
				 		 System.out.println("Successfully deleted "+deleteItem+" item !!!");
				    	 break;
				     }
				}
			} else {
				System.out.println("No Data Found");
			}			
		}
		
		
		System.out.println("\n Do you want to delete any other Item (Yes/No):\n");
		String oneMore = scanner.next();
		if("yes".equalsIgnoreCase(oneMore.toLowerCase())) {
			deleteItem();
		} else {
			chooseOperations();
		}
		
	}
	
	
	
	
	public void editItem() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter todo Item name:\n");
		String todoItem = scanner.next();
		
		if(todoItem!=null){
			if(itemsList!=null && !itemsList.isEmpty()){
				boolean isExist = false;
				for (TodoItem item : itemsList){
				     if(item!=null && item.getItemName().equals(todoItem)){
				    	 
				    	 System.out.println("Enter start date(dd-mm-yyyy) format:\n");
				 		 String startDate = scanner.next();
				 		 Date stDate=  DateUtil.stringToDate(startDate);
				 		 System.out.println("Enter end date(dd-mm-yyyy) format:\n");
				 		 String expiredDate = scanner.next();
				 		 Date exDate= DateUtil.stringToDate(expiredDate);
				 		 System.out.println("Enter description:");
				 		 String desc = scanner.next();
				 										 		 
				 		 item.setDesc(desc);
				 		 item.setStartDate(stDate);
				 		 item.setExpiredDate(exDate);
 
				    	 
				 		 System.out.println("Successfully updated "+todoItem+" item !!!");
					     isExist = true;

					     break;
				     }
				}
				if(!isExist) {
					System.out.println("No Data Found");
				}
			} else {
				System.out.println("No Data Found");
			}			
		}
		
		System.out.println("\n Do you want to edit any other Item (Yes/No):\n");
		String oneMore = scanner.next();
		if("yes".equalsIgnoreCase(oneMore.toLowerCase())) {
			editItem();
		} else {
			chooseOperations();
		}
			
		
	}
	
	
	
public void checkDeadline() {
		if(itemsList!=null && !itemsList.isEmpty()){
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter item name for checking status of deadline:\n");
			String searchItem = scanner.next();
			boolean isExist = false;
			for (TodoItem item : itemsList){		
				if(item!=null && item.getItemName().equals(searchItem)){
					Date currentDate = new Date();
				     if(item!=null && currentDate.after(item.getExpiredDate())){
				    	 System.out.println(searchItem+" has been expired, expired date was "+DateUtil.dateToString(item.getExpiredDate()));
				     } else {
				    	 System.out.println(searchItem+" not yet expired, expired date is "+DateUtil.dateToString(item.getExpiredDate()));	
				     }
				     isExist = true;
			    	 break;
				}				     
			}
			if(!isExist){
				System.out.println("No Data Found");
			}
		} else {
			System.out.println("No Data Found");
		}			
		
		chooseOperations();
				
}
	
	
		
	
	

	
	
	public void remove_done_expired() {
		if(itemsList!=null && !itemsList.isEmpty()){
			for (TodoItem item : itemsList){
			     if(item!=null && item.getStatus().equals(ItemStatus.DONE.toString())){
			    	 itemsList.remove(item);
			    	 break;
			     } 
			     Date currentDate = new Date();
			     if(item!=null && currentDate.after(item.getExpiredDate())){
			    	 itemsList.remove(item);
			    	 break;
			     }
			}
	 		 System.out.println("\n Successfully removed either done/expired items !!!");
		} else {
			System.out.println("No Data Found");
		}			
		
		chooseOperations();
			
}



	public void getDesc() {
		if(itemsList!=null && !itemsList.isEmpty()){
			for (TodoItem item : itemsList){
				 System.out.println("Task Name:"+item.getItemName());
				 System.out.println("Description:"+item.getDesc());                 
				 System.out.println("************************************");
			}
		} else {
			System.out.println("No Data Found");
		}				
		
		chooseOperations();			
	}
	
	
	
	public void searchItem() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Search Item name:\n");
		String searchItem = scanner.next();
		System.out.println("\n Search Results:\n");

		if(itemsList!=null && !itemsList.isEmpty()){
			for (TodoItem item : itemsList){
			     if(item!=null && item.getItemName().equals(searchItem)){
					 System.out.println("\nTask Name:"+item.getItemName());
					 System.out.println("Description:"+item.getDesc());                 
					 System.out.println("Status:"+item.getStatus()); 
					 System.out.println("Start Date:"+DateUtil.dateToString(item.getStartDate())); 
					 System.out.println("End Date:"+DateUtil.dateToString(item.getExpiredDate())); 
			     }
			}
		} else {
			System.out.println("No Data Found");
		}				
		
		chooseOperations();	
		
	}

	
	public void getAllItems() {	

		if(itemsList!=null && !itemsList.isEmpty()){
			for (TodoItem item : itemsList){
			     if(item!=null){

					 System.out.println("\nTask Name:"+item.getItemName());
					 System.out.println("Description:"+item.getDesc());                 
					 System.out.println("Status:"+item.getStatus()); 
					 System.out.println("Start Date:"+DateUtil.dateToString(item.getStartDate())); 
					 System.out.println("End Date:"+DateUtil.dateToString(item.getExpiredDate())); 
 					 System.out.println("********************\n");

			     }
			}
		} else {
			System.out.println("No Data Found");
		}				
		
		chooseOperations();
		
	}
	
	public Map<Integer,String> loadOperations() {
		Map<Integer,String> map = new LinkedHashMap<Integer,String>();
		map.put(1, "Add Item");
		map.put(2, "Delete Item");
		map.put(3, "Edit Status");
		map.put(4, "Check Deadline");
		map.put(5, "Remove done/expired Item");
		map.put(6, "Get Description");
		map.put(7, "Search Item");		
		map.put(8, "List of todo Items");		
		map.put(9, "exit");		
		return map;
	}

	

	
}
