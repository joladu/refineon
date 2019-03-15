package com.jola.refineframe.ui.main.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.view.RxView;
import com.jola.refineframe.R;
import com.jola.refineframe.app.Constants;
import com.jola.refineframe.base.activity.BaseActivity;
import com.jola.refineframe.contract.main.LoginContract;
import com.jola.refineframe.presenter.main.LoginPresenter;
import com.jola.refineframe.utils.CommonUtils;
import com.jola.refineframe.utils.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;



public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.login_group)
    RelativeLayout mLoginGroup;
    @BindView(R.id.login_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.login_account_edit)
    EditText mAccountEdit;
    @BindView(R.id.login_password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.login_btn)
    Button mLoginBtn;
    @BindView(R.id.login_register_btn)
    Button mRegisterBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolbar() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, mToolbar);
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {
        subscribeLoginClickEvent();
    }

    @Override
    public void showLoginSuccess() {
        CommonUtils.showMessage(this, getString(R.string.login_success));
        onBackPressedSupport();
    }

    @OnClick({R.id.login_register_btn})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_register_btn:
                startRegisterPager();
                break;
            default:
                break;
        }
    }

    private void startRegisterPager() {
        ActivityOptions options = ActivityOptions.makeScaleUpAnimation(mRegisterBtn,
                mRegisterBtn.getWidth() / 2,
                mRegisterBtn.getHeight() / 2,
                0 ,
                0);
//        startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
        CommonUtils.showMessage(this, "注册");
    }

    private void subscribeLoginClickEvent() {
        mPresenter.addRxBindingSubscribe(RxView.clicks(mLoginBtn)
                .throttleFirst(Constants.CLICK_TIME_AREA, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o -> mPresenter.getLoginData(
                        mAccountEdit.getText().toString().trim(),
                        mPasswordEdit.getText().toString().trim())));
    }

}
