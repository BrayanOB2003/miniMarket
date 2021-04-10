package model;

public class Record {

	private String idType;
	private long ID;
	
	public Record(int typeNumber, long ID) {
		this.idType = TypeID.values()[typeNumber].toString();
        this.ID = ID;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public long getId() {
		return ID;
	}

	public void setId(long id) {
		this.ID = id;
	}
}
