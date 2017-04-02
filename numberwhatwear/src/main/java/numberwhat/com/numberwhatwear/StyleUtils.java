package numberwhat.com.numberwhatwear;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;

/**
 * Created by Miix on 2017-04-01.
 */

public class StyleUtils {

    public static Paint getDialBackgroundPaint(Context ctx) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ContextCompat.getColor(ctx, R.color.colorDial));
        p.setStyle(Paint.Style.FILL);
        return p;
    }

    public static Paint getMinuteBoardPaint(Context ctx) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(ContextCompat.getColor(ctx, R.color.colorMinuteBoard));
        p.setStyle(Paint.Style.FILL);
        return p;
    }

    public static Paint getHourTextPaint(Context ctx,boolean alignLeft,int minutes) {
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setFakeBoldText(true);
        p.setTextSize(60);
        if(alignLeft){

            p.setTextAlign(Paint.Align.LEFT);
        }else{
            p.setTextAlign(Paint.Align.RIGHT);
        }

        if(minutes < 30){
            p.setColor(ContextCompat.getColor(ctx, R.color.colorHourText1));
        }else if(minutes > 54){
            p.setColor(ContextCompat.getColor(ctx, R.color.colorHourText1));
        }else{
            p.setColor(ContextCompat.getColor(ctx, R.color.colorHourText2));
        }

        p.setTypeface(Typeface.DEFAULT_BOLD);
        //p.setColor(ContextCompat.getColor(ctx, R.color.colorHourText));
        p.setStyle(Paint.Style.FILL);
        return p;

    }
}
