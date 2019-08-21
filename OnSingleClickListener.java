import android.os.SystemClock;
import android.view.View;

/**
 * Created by Royser @Nextzy on 2019-08-21.
 */
public abstract class OnSingleClickListener implements View.OnClickListener {

    private static final long MIN_CLICK_INTERVAL = 1000;
    private long mLastClickTime;

    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        long currentClickTime = SystemClock.uptimeMillis();
        long elapsedTime = currentClickTime - mLastClickTime;

        mLastClickTime = currentClickTime;

        if (elapsedTime <= MIN_CLICK_INTERVAL)
            return;

        onSingleClick(v);
    }
    
//    view.setOnClickListener(new OnSingleClickListener() {
//        @Override
//        public void onSingleClick(View v) {
//            //do something.
//        }
//    };

}
