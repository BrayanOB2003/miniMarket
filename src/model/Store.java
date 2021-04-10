package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import exception.ExceptionDate;
import exception.ExceptionTypeID;

public class Store {
		
		public final static String ID_TYPE = "TI";
	    private List<Record> records;
	    private int count;
	    
	    public Store() {
	        records = new ArrayList<>();
	    }
	    
	    public List<Record> getRecords() {
		    return records;
		}

		public void setRecords(List<Record> records) {
		    this.records = records;
		}

		public long getCount() {
	        return count;
	    }

	    public void setCount(int count) {
	        this.count = count;
	    }
	    
	    public void addRecord (LocalDate date, int tNumber, long id) throws ExceptionTypeID, ExceptionDate{
	        

	        DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	        String datetxt = format.format(date);
	        String[] parts = datetxt.split("/");
	        int day = Integer.parseInt(parts[2]);

	        if(!typeValidation(TypeID.values()[tNumber].name())){
	            throw new ExceptionTypeID(TypeID.values()[tNumber].name());
	        }

	        if(!evenDay(day, id)){
	            
	            throw new ExceptionDate(id, day);
	        }
	        Record temp = new Record(tNumber, id);
	        records.add(temp);
	    }
	    
	    
	    public boolean evenDay(int day, long id){
	        boolean access = false;

	        if(day%2 == 0 && id%2 != 0){
	           access = true;
	        } else if (day%2 != 0 && id%2 == 0) {
	            access = true;
	        }

	        return access;
	    }
	    
	    public void addCount(){
		    count++;
		}

		public boolean typeValidation(String tp){
	        boolean access = false;

	        if(!tp.equals(ID_TYPE)){
	            access = true;
	        }
	        return access;
	    }
}
