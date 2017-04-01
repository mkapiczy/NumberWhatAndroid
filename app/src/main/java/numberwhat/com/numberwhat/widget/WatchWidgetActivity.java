package numberwhat.com.numberwhat.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

import numberwhat.com.numberwhat.scheduling.AlarmManagerReceiver;
import numberwhat.com.numberwhat.utils.RenderUtils;
import numberwhat.com.numberwhat.utils.StyleUtils;


public class WatchWidgetActivity extends AppWidgetProvider {

    public static final String ACTION_AUTO_UPDATE = "AUTO_UPDATE";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        RenderUtils.updateClock(context);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        System.out.println("onUpdate");
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(ACTION_AUTO_UPDATE)) {
           /*
           DO Something not sure what right now
            */
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        setupAlarmManager(context);
    }

    @Override
    public void onDisabled(Context context) {
        /*
        TODO
        ADD cancelation of alarmManager
         */
    }

    private void setupAlarmManager(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        long s = System.currentTimeMillis();
        long l = s % 60000;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (60000 - l), 60000, pendingIntent);
    }
}

