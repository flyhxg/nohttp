package com.example.hxg.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by hxg on 2016/5/9.
 */
public class PercentRelativeLayout extends RelativeLayout {
    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    public PercentRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        for (int i=0;i<getChildCount();i++){
            View child = getChildAt(i);
            ViewGroup.LayoutParams params = child.getLayoutParams();
            float widthPercent=0;
            float heightPercent=0;
            if (params instanceof  PercentRelativeLayout.RelatLayoutParams){
                widthPercent =((RelatLayoutParams) params).getWidthPercent();
                heightPercent = ((RelatLayoutParams) params).getHeightPercent();

            }
            if (widthPercent==0||heightPercent==0){
                continue;
            }
           params.width = (int) (widthSize*widthPercent);
            params.height = (int) (heightSize*heightPercent);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
  /*
如果一个View想要被添加到这个容器中，这个view可以调用此方法生成和容器类匹配的布局LayoutParams;
   */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new RelatLayoutParams(getContext(),attrs);
    }
    /*

     */
    public static class RelatLayoutParams extends  LayoutParams{
        private float widthPercent;
        private float heightPercent;

        public float getWidthPercent() {
            return widthPercent;
        }

        public void setWidthPercent(float widthPercent) {
            this.widthPercent = widthPercent;
        }

        public float getHeightPercent() {
            return heightPercent;
        }

        public void setHeightPercent(float heightPercent) {
            this.heightPercent = heightPercent;
        }

        public RelatLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs,R.styleable.PercentRelativeLayout);
            widthPercent = typedArray.getFloat(R.styleable.PercentRelativeLayout_Percent_layout_width,widthPercent);
            heightPercent = typedArray.getFloat(R.styleable.PercentRelativeLayout_Percent_layout_height,heightPercent);
            typedArray.recycle();
        }

        public RelatLayoutParams(int w, int h) {
            super(w, h);
        }

        public RelatLayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public RelatLayoutParams(MarginLayoutParams source) {
            super(source);
        }


    }
}
