package numberwhat.com.numberwhat.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.RemoteViews;

import numberwhat.com.numberwhat.R;
import numberwhat.com.numberwhat.scheduling.AlarmManagerReceiver;
import numberwhat.com.numberwhat.scheduling.ClockUpdateScheduler;
import numberwhat.com.numberwhat.utils.DateUtils;
import numberwhat.com.numberwhat.utils.StyleUtils;


public class WatchWidgetActivity extends AppWidgetProvider {

    public static final String ACTION_AUTO_UPDATE = "AUTO_UPDATE";

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.watch_widget_activity);

        Bitmap bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        canvas.drawCircle(canvasWidth / 2, canvasHeight / 2, canvasWidth / 2,
                StyleUtils.getDialBackgroundPaint(context));

        int minutesInDegrees = 6 * DateUtils.getCurrentMinutes();

        canvas.drawArc(new RectF(0, 0, canvasWidth, canvasHeight), -90, minutesInDegrees, true,
                StyleUtils.getMinuteBoardPaint(context));

        views.setImageViewBitmap(R.id.imageView1, bitmap);
        appWidgetManager.updateAppWidget(appWidgetId, views);
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
        System.out.println("PRAWIE");
        if (intent.getAction().equals(ACTION_AUTO_UPDATE)) {
            System.out.println("TEST!");
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        System.out.println("TEST!");
        AlarmManager am=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        long s = System.currentTimeMillis();
        long l = s % 60000;

        System.out.println(l);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ (60000-l), 60000 , pi);
    }

    @Override
    public void onDisabled(Context context) {

    }
}

