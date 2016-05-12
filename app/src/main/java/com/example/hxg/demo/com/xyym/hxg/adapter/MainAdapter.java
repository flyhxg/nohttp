package com.example.hxg.demo.com.xyym.hxg.adapter;

import android.content.Context;
import android.util.Log;

import com.example.hxg.demo.API;
import com.example.hxg.demo.R;
import com.example.hxg.demo.com.xyym.hxg.modeal.entity.TiangouEntity;

import java.util.List;

/**
 * Created by hxg on 2016/5/11.
 */
public class MainAdapter extends  RecyclerBaseAdapter<TiangouEntity.TngouBean> {
    public MainAdapter(Context context, int layoutResId, List data) {
        super(context, layoutResId, data);
    }




    @Override
    protected void convert(BaseViewHolder helper, TiangouEntity.TngouBean item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setImgaeUrl(R.id.image_title, API.URL_IMAGE+item.getImg());
        helper.setText(R.id.tv_content,item.getDescription());
        helper.setText(R.id.tv_time,item.getTime()+"");
    }
}
