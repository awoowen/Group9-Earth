package crm;

public class CardNotFoundException extends Exception
{
    private String msg;
    public CardNotFoundException(String err)
    {
        msg = err;
    }

    public String toString()
    {
        return(msg);
    }
}
