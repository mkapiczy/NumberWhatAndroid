package numberwhat.com.numberwhatwear;

import java.util.Calendar;


public class DateUtils {

    public static int getCurrentMinutes() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    public static int getCurrentHour() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR);
    }
}
