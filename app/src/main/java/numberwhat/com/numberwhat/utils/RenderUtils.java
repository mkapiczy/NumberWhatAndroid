package numberwhat.com.numberwhat.utils;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.widget.RemoteViews;

import numberwhat.com.numberwhat.R;
import numberwhat.com.numberwhat.widget.WatchWidgetActivity;


public class RenderUtils {

    public static void updateClock(Context context) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.watch_widget_activity);

        Bitmap bitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        canvas.drawCircle(canvasWidth / 2, canvasHeight / 2, canvasWidth / 2,
                StyleUtils.getDialBackgroundPaint(context));

        int minutes = DateUtils.getCurrentMinutes();
        int hour = DateUtils.getCurrentHour();

        if(hour == 0){
            hour = 12;
        }

        int minutesInDegrees = 6 * minutes;

        canvas.drawArc(new RectF(0, 0, canvasWidth, canvasHeight), -90, minutesInDegrees, true,
                StyleUtils.getMinuteBoardPaint(context));
        boolean alignLeft = false;
        int hourMargin = canvasWidth / 30;
        int hourXPosition;

        if (minutes < 30) {
            hourXPosition = canvasWidth / 2 + hourMargin;
            alignLeft = true;
        } else {
            hourXPosition = canvasWidth / 2 - hourMargin;
            alignLeft = false;
            if (hour == 12) {
                hour = 1;
            } else {
                hour = hour + 1;
            }
        }

        int hourYPosition = canvasHeight / 5 + canvasHeight / 25 ;

        canvas.drawText(Integer.toString(hour), hourXPosition, hourYPosition, StyleUtils.getHourTextPaint(context,alignLeft));
        views.setImageViewBitmap(R.id.imageView1, bitmap);

        ComponentName thiswidget = new ComponentName(context, WatchWidgetActivity.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(thiswidget, views);
    }
}
