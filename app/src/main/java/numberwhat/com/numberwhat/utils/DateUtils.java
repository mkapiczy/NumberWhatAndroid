package numberwhat.com.numberwhat.utils;

import java.util.Calendar;

/**
 * Created by Miix on 2017-04-01.
 */

public class DateUtils {

    public static int getCurrentMinutes(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    public static String getCurrentHourString(){
        Calendar calendar = Calendar.getInstance();
        return Integer.toString(calendar.get(Calendar.HOUR));
    }
}
