package Polymorph.src.Tools;

public class ErrorHandler
{
    public static class Input
    {
        public static boolean IsValid(Number value)
        {
            return value.doubleValue() != -1;
        }
        public static boolean IsValid(Object value) {
            return value != null;
        }
    }

    public static void Assert(boolean value)
    {
        if(!value)
            throw new AssertionError();
    }

}
