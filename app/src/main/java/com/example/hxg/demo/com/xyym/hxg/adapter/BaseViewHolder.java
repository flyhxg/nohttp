package com.example.hxg.demo.com.xyym.hxg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by hxg on 2016/5/11.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final Context mContext;
    public  View ConvertView;
    private  final SparseArray<View>  views;


    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        ConvertView = itemView;
        views = new SparseArray<View>();

    }
    public BaseViewHolder setText(int resId,CharSequence charSequence){
        TextView textView = getView(resId);
        textView.setText(charSequence);
        return this;
    }
    public BaseViewHolder setImgaeUrl(int resId,String url){
        ImageView imageView = getView(resId);
        Glide.with(mContext).load(url).centerCrop().into(imageView);
        return this;
    }
    public BaseViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }
    @SuppressWarnings("unchecked")
  public <T extends  View>  T getView(int id){

      View view = views.get(id);
      if (view==null){
          view =ConvertView.findViewById(id);
          views.put(id,view);
      }
      return (T) view;
  }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
    public BaseViewHolder setOnClickListener(int viewId, RecyclerBaseAdapter.OnItemChildClickListener listener) {
        View view = getView(viewId);
        listener.position = getAdapterPosition();
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * Sets the adapter of a adapter view.
     *
     * @param viewId  The view id.
     * @param adapter The adapter;
     * @return The BaseViewHolder for chaining.
     */
    public BaseViewHolder setAdapter(int viewId, Adapter adapter) {
        AdapterView view = getView(viewId);
        view.setAdapter(adapter);
        return this;
    }

}
