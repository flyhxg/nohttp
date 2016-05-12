package com.example.hxg.demo.com.xyym.hxg.present;

import android.content.Context;

import com.example.commen.ui.MvpBasePresenter;
import com.example.commen.ui.activity.BaseView;
import com.example.hxg.demo.com.xyym.hxg.modeal.Modeal.MainModeal;
import com.example.hxg.demo.network.HttpListener;
import com.yolanda.nohttp.Response;

import org.json.JSONObject;

/**
 * Created by hxg on 2016/5/12.
 */
public class MainPresent  extends MvpBasePresenter<MainPresent.MainView> {
    private static final int GET_CONENT = 1;

    public interface MainView extends BaseView {


        void getResponse(String response);

        void getError(String error);

    }

    private MainView mMainView;
    private MainModeal mMainModeal;

    public MainPresent(MainView context) {
        this.mMainView = context;
        mMainModeal = new MainModeal();
    }

    public void showContent(String url) {
        mMainModeal.showContent((Context) mMainView, url, mObjectHttpListener(GET_CONENT));
    }

    private HttpListener<JSONObject> mObjectHttpListener(final int caseID) {
        return new HttpListener<JSONObject>() {
            @Override
            public void onSucceed(int what, Response<JSONObject> response) {
                switch (caseID) {
                    case GET_CONENT:

                        mMainView.getResponse(response.toString());
                        break;

                }
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                switch (caseID) {
                    case GET_CONENT:
                        mMainView.getError(exception.toString());
                        break;

                }

            }
        };
    }
}
