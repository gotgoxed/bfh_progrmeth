import java.io.IOException;

/**
   This class reports bad input data.
*/

@SuppressWarnings("serial")
public class BadDataException extends IOException
{
   public BadDataException() {}
   public BadDataException(String message)
   {
      super(message);
   }
}
