package org.liangxw.travelfinder.ui;

import android.app.Activity;
import android.os.Bundle;

import org.liangxw.travelfinder.R;
import org.liangxw.travelfinder.component.ActivityStack;
import org.liangxw.travelfinder.util.BaseActivity;
import org.liangxw.travelfinder.util.logger.Log;


public class GroupQRCodeActivity extends BaseActivity implements ActivityStack.ActivityRule {

    private final static String TAG = GroupQRCodeActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_group_qr_code);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ActivityStack.ActivityRule getActivityRule() {
        return this;
    }

    @Override
    public boolean onPop(Activity prev, Activity now) {
        Log.i(TAG, "onPop, prev:"+ prev.getClass().getSimpleName());
        if (!(prev instanceof GroupMapActivity)) {
            Log.i(TAG, "create");
            startActivity(GroupMapActivity.class);
        }
        return true;
    }
}