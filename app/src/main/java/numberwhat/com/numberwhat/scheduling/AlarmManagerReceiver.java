package numberwhat.com.numberwhat.scheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

import numberwhat.com.numberwhat.utils.RenderUtils;
import numberwhat.com.numberwhat.utils.StyleUtils;

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

        RenderUtils.updateClock(context);
        //Release the lock
        wl.release();
    }
}
