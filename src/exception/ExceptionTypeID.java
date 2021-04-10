package exception;

public class ExceptionTypeID extends Exception {
    private static final long serialVersionUID = 1L;
    
    private String type;

    public ExceptionTypeID(String type) {
        super(type + " ID it's not allow to pass");
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}