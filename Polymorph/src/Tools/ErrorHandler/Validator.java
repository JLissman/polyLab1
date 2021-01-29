package Polymorph.src.Tools.ErrorHandler;

public class Validator
{
    public static boolean IsValid(Number value)
    {
        return value.doubleValue() != -1;
    }
    public static boolean IsValid(Object value)
    {
        return value != null;
    }
}
