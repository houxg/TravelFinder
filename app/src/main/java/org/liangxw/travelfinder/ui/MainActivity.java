package org.liangxw.travelfinder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.liangxw.travelfinder.R;
import org.liangxw.travelfinder.component.ActivityStack;
import org.liangxw.travelfinder.util.BaseActivity;
import org.liangxw.travelfinder.util.TitleTool;


public class MainActivity extends BaseActivity implements View.OnClickListener, ActivityStack.ActivityRule {

    private final static String TAG = MainActivity.class.getSimpleName();
    boolean needLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!isLogin()) {
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        TitleTool.setLeftActionText(this, "我");
        TitleTool.addAction(this, R.id.btn_create_group, "建", this);
    }

    private boolean isLogin() {

        return false;
    }


    @Override
    protected void onRightButtonClicked() {
        toast("还没有搞好哟");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create_group:
                startActivity(CreateGroupActivity.class);
                break;
        }
    }

    @Override
    public boolean onPop(Activity prev, Activity now) {
        if (needLogin && !(prev instanceof LoginActivity)) {
            startActivity(LoginActivity.class);
        }
        return true;
    }
}
