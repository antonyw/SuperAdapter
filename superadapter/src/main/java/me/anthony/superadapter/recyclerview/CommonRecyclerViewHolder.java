package me.anthony.superadapter.recyclerview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Anthony on 2017/2/11.
 */

public class CommonRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    /**
     * 被实例化过的View的缓存
     */
    private SparseArray<View> viewArray;

    private View contentView;

    private OnItemClickListener clickListener;
    private OnItemLongClickListener longClickListener;

    CommonRecyclerViewHolder(View itemView, OnItemClickListener clickListener, OnItemLongClickListener longClickListener) {
        super(itemView);
        this.contentView = itemView;
        this.viewArray = new SparseArray<>();
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    private <T extends View> T getView(int viewId) {
        View v = viewArray.get(viewId);

        if (null == v) {
            v = contentView.findViewById(viewId);
            viewArray.put(viewId, v);
        }
        return (T) v;
    }

    /**
     * For TextView.setText
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonRecyclerViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * For Button.setText
     *
     * @param viewId
     * @param text
     * @return
     */
    public CommonRecyclerViewHolder setButtonText(int viewId, String text) {
        Button btn = getView(viewId);
        btn.setText(text);
        return this;
    }

    /**
     * For CheckBox.setChecked
     *
     * @param viewId
     * @param checked
     * @return
     */
    public CommonRecyclerViewHolder setCheckBox(int viewId, boolean checked) {
        CheckBox cb = getView(viewId);
        cb.setChecked(checked);
        return this;
    }

    /**
     * set image with resource
     *
     * @param viewId
     * @param resId
     * @return
     */
    public CommonRecyclerViewHolder setImageView(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    /**
     * set image with bitmap
     *
     * @param viewId
     * @param bitmap
     * @return
     */
    public CommonRecyclerViewHolder setImageView(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * set image with uri
     *
     * @param viewId
     * @param uri
     * @return
     */
    public CommonRecyclerViewHolder setImageView(int viewId, Uri uri) {
        ImageView iv = getView(viewId);
        iv.setImageURI(uri);
        return this;
    }

    /**
     * set the view is visible
     *
     * @param viewId
     * @param isVisible
     * @return
     */
    public CommonRecyclerViewHolder setVisible(int viewId, int isVisible) {
        View v = getView(viewId);
        v.setVisibility(isVisible);
        return this;
    }

    public CommonRecyclerViewHolder setClickListener(int viewId, View.OnClickListener listener) {
        View v = getView(viewId);
        v.setOnClickListener(listener);
        return this;
    }

    public CommonRecyclerViewHolder setLongClickListener(int viewId, View.OnLongClickListener longClickListener) {
        View v = getView(viewId);
        v.setOnLongClickListener(longClickListener);
        return this;
    }


    @Override
    public void onClick(View v) {
        if (clickListener != null)
            clickListener.onItemClick(v, getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View v) {
        if (longClickListener != null)
            longClickListener.onItemLongClick(v, getAdapterPosition());
        return true;
    }
}
