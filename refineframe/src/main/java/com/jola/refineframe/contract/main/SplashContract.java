package com.jola.refineframe.contract.main;


import com.jola.refineframe.base.presenter.AbstractPresenter;
import com.jola.refineframe.base.view.AbstractView;

public interface SplashContract {

    interface View extends AbstractView {
        /**
         * after some time jump to main page
         */
        void jumpToMain();
    }

    interface Presenter extends AbstractPresenter<View> {

    }

}
