package numberwhat.com.numberwhat.scheduling;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.PowerManager;
import android.widget.RemoteViews;

import java.util.Date;

import numberwhat.com.numberwhat.R;
import numberwhat.com.numberwhat.utils.DateUtils;
import numberwhat.com.numberwhat.utils.StyleUtils;
import numberwhat.com.numberwhat.widget.WatchWidgetActivity;

/**
 * Created by Miix on 2017-04-01.
 */

public class AlarmManagerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("AlarmManagerReceiver!");
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
        //Acquire the lock
        wl.acquire();

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


        ComponentName thiswidget = new ComponentName(context, WatchWidgetActivity.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(thiswidget, views);
        //Release the lock
        wl.release();
    }
}
