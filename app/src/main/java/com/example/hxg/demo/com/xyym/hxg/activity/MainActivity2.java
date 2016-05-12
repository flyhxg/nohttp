package com.example.hxg.demo.com.xyym.hxg.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.commen.ui.activity.BaseAppCompatActivity;
import com.example.commen.util.eventbus.EventCenter;
import com.example.commen.util.netstatus.NetUtils;
import com.example.hxg.demo.API;
import com.example.hxg.demo.R;
import com.example.hxg.demo.com.xyym.hxg.Constract;
import com.example.hxg.demo.com.xyym.hxg.adapter.MainAdapter;
import com.example.hxg.demo.com.xyym.hxg.modeal.entity.TiangouEntity;
import com.example.hxg.demo.com.xyym.hxg.present.MainPresent;
import com.example.hxg.demo.com.xyym.hxg.util.GsonUtil;

import butterknife.InjectView;


/**
 * Created by hxg on 2016/5/11.
 */
public class MainActivity2 extends BaseAppCompatActivity<MainPresent.MainView,MainPresent>  implements MainPresent.MainView{
    @InjectView(R.id.id_recyclerview2)
    RecyclerView mIdRecyclerview2;


    TiangouEntity entity;


    private int page = 1;

    MainAdapter adapter;
    @Override
    public void initData() {
        super.initData();
        toggleShowLoading(true,"");//?id=0&page=1&rows=20
        presenter.showContent(API.URL_LIST+"?id=0&page="+page+"&rows="+ Constract.ROWS);

    }

    @NonNull
    @Override
    public MainPresent createPresenter() {
        return new MainPresent(this);
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main2;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {

        return mIdRecyclerview2;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }


    @Override
    public void getResponse(String response) {
        toggleShowLoading(false,"");

        TiangouEntity entity = GsonUtil.fromJson(response,TiangouEntity.class);
        adapter  = new MainAdapter(this,R.layout.main_item,entity.getTngou());
        mIdRecyclerview2.setLayoutManager(new LinearLayoutManager(this));
        mIdRecyclerview2.setAdapter(adapter);
    }

    @Override
    public void getError(String error) {
        toggleShowError(true,"", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();

            }
        });
    }
}
