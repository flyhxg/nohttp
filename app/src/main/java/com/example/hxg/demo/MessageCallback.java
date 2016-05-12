package com.example.hxg.demo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.hxg.demo.com.xyym.hxg.adapter.ItemTouchHelperAdapter;

/**
 * Created by hxg on 2016/5/10.
 */
public class MessageCallback extends ItemTouchHelper.Callback {
    ItemTouchHelperAdapter mAdapter;
    MessageCallback(ItemTouchHelperAdapter adapter){
        this.mAdapter = adapter;
    }
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        return makeMovementFlags(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.LEFT);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }


    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState==ItemTouchHelper.ACTION_STATE_SWIPE){
            float alpha =1- Math.abs(dX)/viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);
            viewHolder.itemView.setScaleX(Math.max(0.5f,alpha));
            viewHolder.itemView.setScaleY(Math.max(0.5f,alpha));
            viewHolder.itemView.setTranslationX(dX);
            if (alpha<=0){
                viewHolder.itemView.setAlpha(1);
                viewHolder.itemView.setScaleX(1);
                viewHolder.itemView.setScaleY(1);
            }


        }
       else{
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

    }



    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
