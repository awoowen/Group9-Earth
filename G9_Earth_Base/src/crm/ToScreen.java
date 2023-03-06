package crm;
//Most likely, I will be changing the class name, but I pretty much want something first
public class ToScreen<T> {
    public static <T>void toScreen(T obj)
    {
        System.out.println(obj.toString());
    }
}
