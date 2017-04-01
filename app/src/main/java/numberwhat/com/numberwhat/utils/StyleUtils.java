package numberwhat.com.numberwhat.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;

import numberwhat.com.numberwhat.R;

/**
 * Created by Miix on 2017-04-01.
 */

public class StyleUtils {

    public static Paint getDialBackgroundPaint(Context ctx){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ContextCompat.getColor(ctx, R.color.colorDial));
        p.setStyle(Paint.Style.FILL);
        return p;
    }

    public static Paint getMinuteBoardPaint(Context ctx){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ContextCompat.getColor(ctx, R.color.colorMinuteBoard));
        p.setStyle(Paint.Style.FILL);
        return p;
    }

    public static Paint getHourTextPaint(Context ctx){
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ContextCompat.getColor(ctx, R.color.colorHourText));
        p.setStyle(Paint.Style.FILL);
        return p;

    }
}
