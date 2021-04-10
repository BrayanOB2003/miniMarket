package exception;

public class ExceptionDate extends Exception {
    private static final long serialVersionUID = 1L;

    private long ID;
    private int day;

    public ExceptionDate(long id2,int day){
        super("The" + id2 + " don't match with" + day + "This day isn't the expected day to access");
        this.ID = id2;
        this.day = day; 
    }

    public boolean validationPair(){
        boolean access = false;

        if(day%2 == 0 && ID%2 != 0){
           access = true;
        } else if (day%2 != 0 && ID%2 == 0) {
            access = true;
        }

        return access;
    }
}