package numberwhat.com.numberwhat.utils;

import java.util.Calendar;
import java.util.Locale;


public class DateUtils {

    public static int getCurrentMinutes() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        return calendar.get(Calendar.MINUTE);
    }

    public static int getCurrentHour() {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        return calendar.get(Calendar.HOUR);
    }
}
