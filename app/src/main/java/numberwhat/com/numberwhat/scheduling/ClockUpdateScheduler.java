package numberwhat.com.numberwhat.scheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Calendar;

import numberwhat.com.numberwhat.widget.WatchWidgetActivity;

/**
 * Created by Miix on 2017-04-01.
 */

public class ClockUpdateScheduler {

    private final int ALARM_ID = 0;
    private final int INTERVAL_MILLIS = 3600;

    private Context mContext;


    public ClockUpdateScheduler(Context context) {
        mContext = context;
    }


    public void startAlarm() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, INTERVAL_MILLIS);

        Intent alarmIntent = new Intent(WatchWidgetActivity.ACTION_AUTO_UPDATE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, ALARM_ID,
                alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), INTERVAL_MILLIS,
                pendingIntent);
    }


    public void stopAlarm() {
        Intent alarmIntent = new Intent(WatchWidgetActivity.ACTION_AUTO_UPDATE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, ALARM_ID,
                alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }
}
