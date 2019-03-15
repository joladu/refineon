package com.jola.refineframe.ui.main.activity;

import android.content.Intent;


import com.jola.refineframe.R;
import com.jola.refineframe.app.MyApplication;
import com.jola.refineframe.base.activity.BaseActivity;
import com.jola.refineframe.contract.main.SplashContract;
import com.jola.refineframe.presenter.main.SplashPresenter;

import butterknife.BindView;




public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initToolbar() {
//        if (!MyApplication.isFirstRun) {
//            jumpToMain();
//            return;
//        }
//        WanAndroidApp.isFirstRun = false;
//        StatusBarUtil.immersive(this);
    }

    @Override
    protected void initEventAndData() {
    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }




}
