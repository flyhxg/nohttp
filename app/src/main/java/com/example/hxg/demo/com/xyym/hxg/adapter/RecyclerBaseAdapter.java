package com.example.hxg.demo.com.xyym.hxg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxg on 2016/5/11.
 */
public abstract class RecyclerBaseAdapter<T> extends RecyclerView.Adapter {

    protected Context mContext;
    protected int mLayoutResId;

    protected List<T> mData;
   public  RecyclerBaseAdapter(Context context, int layoutResId, List<T> data){
       this.mData = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
       this.mContext = context;

       if (layoutResId != 0) {
           this.mLayoutResId = layoutResId;
       }
    }
    public RecyclerBaseAdapter(Context context, List<T> data) {
        this(context, 0, data);
    }

    public RecyclerBaseAdapter(Context context) {
        this(context, null);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent,mLayoutResId);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        convert((BaseViewHolder) holder,mData.get(position));

    }

    private OnRecyclerViewItemChildClickListener mChildClickListener;

    public void setOnRecyclerViewItemChildClickListener(OnRecyclerViewItemChildClickListener childClickListener) {
        this.mChildClickListener = childClickListener;
    }

    public interface OnRecyclerViewItemChildClickListener {
        void onItemChildClick(RecyclerBaseAdapter adapter, View view, int position);
    }

    public class OnItemChildClickListener implements View.OnClickListener {
        public int position;

        @Override
        public void onClick(View v) {
            if (mChildClickListener != null)
                mChildClickListener.onItemChildClick(RecyclerBaseAdapter.this, v, position);
        }
    }
    protected BaseViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return new BaseViewHolder(mContext, getItemView(layoutResId, parent));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    protected View getItemView(int layoutResId, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
    }
    protected abstract void convert(BaseViewHolder helper, T item);
}
