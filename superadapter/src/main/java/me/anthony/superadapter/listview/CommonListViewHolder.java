package me.anthony.superadapter.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Anthony on 2017/2/11.
 */

public class CommonListViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    CommonListViewHolder(Context context, ViewGroup parent, int layoutId, int position) {

        this.mPosition = position;
        this.mViews = new SparseArray<>();

        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);

        mConvertView.setTag(this);
    }

    //入口方法判断是否new CommonListViewHolder
    static CommonListViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new CommonListViewHolder(context, parent, layoutId, position);
        } else {
            CommonListViewHolder holder = (CommonListViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    //通过viewID获取控件
    private <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);

        //判断是否存储过这个view
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    View getConvertView() {
        return mConvertView;
    }

    /**
     * 向TextView填充数据
     *
     * @param viewId
     * @param text   String类型数据
     * @return
     */
    public CommonListViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置控件是否显示
     *
     * @param viewId
     * @param isVisible
     * @return
     */
    public CommonListViewHolder setVisible(int viewId, int isVisible) {
        View tv = getView(viewId);
        tv.setVisibility(isVisible);
        return this;
    }

    /**
     * 设置控件内部点击事件
     *
     * @param viewId
     * @param listener
     * @return
     */
    public CommonListViewHolder setHolderClickListener(int viewId, View.OnClickListener listener) {
        View v = getView(viewId);
        v.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置控件内部长按事件
     *
     * @param viewId
     * @param longClickListener
     * @return
     */
    public CommonListViewHolder setHolderLongClickListener(int viewId, View.OnLongClickListener longClickListener) {
        View v = getView(viewId);
        v.setOnLongClickListener(longClickListener);
        return this;
    }

    /**
     * 设置Button文字
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonListViewHolder setButton(int viewId, String text) {
        Button btn = getView(viewId);
        btn.setText(text);
        return this;
    }

    /**
     * 向ImageView填充数据
     *
     * @param viewId
     * @param resId  Resource资源对应
     * @return
     */
    public CommonListViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    /**
     * 向CheckBox填充数据
     *
     * @param viewId
     * @param isChecked 是否填充为选中状态
     * @return
     */
    public CommonListViewHolder setCheckBox(int viewId, boolean isChecked) {
        CheckBox cb = getView(viewId);
        cb.setChecked(isChecked);
        return this;
    }

    /**
     * 向ImageView填充数据
     *
     * @param viewId
     * @param bitmap
     * @return
     */
    public CommonListViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 向ImageView填充数据
     *
     * @param viewId
     * @param uri
     * @return
     */
    public CommonListViewHolder setImageUri(int viewId, Uri uri) {
        ImageView iv = getView(viewId);
        iv.setImageURI(uri);
        return this;
    }
}
