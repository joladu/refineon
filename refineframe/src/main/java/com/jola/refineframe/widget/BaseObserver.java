package com.jola.refineframe.widget;

import android.text.TextUtils;

import com.jola.refineframe.R;
import com.jola.refineframe.app.MyApplication;
import com.jola.refineframe.base.view.AbstractView;
import com.jola.refineframe.core.http.exception.ServerException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;



public abstract class BaseObserver<T> extends ResourceObserver<T> {

    private AbstractView mView;
    private String mErrorMsg;
    private boolean isShowError = true;

    protected BaseObserver(AbstractView view){
        this.mView = view;
    }

    protected BaseObserver(AbstractView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected BaseObserver(AbstractView view, boolean isShowError){
        this.mView = view;
        this.isShowError = isShowError;
    }

    protected BaseObserver(AbstractView view, String errorMsg, boolean isShowError){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        if (mView == null) {
            return;
        }
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (e instanceof ServerException) {
            mView.showErrorMsg(e.toString());
        } else if (e instanceof HttpException) {
                mView.showErrorMsg(MyApplication.getInstance().getString(R.string.http_error));
        } else {
            mView.showErrorMsg(MyApplication.getInstance().getString(R.string.unKnown_error));
//            LogHelper.d(e.toString());
        }
        if (isShowError) {
            mView.showError();
        }
    }
}
