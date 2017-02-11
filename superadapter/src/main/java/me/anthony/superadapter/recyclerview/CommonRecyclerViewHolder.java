package me.anthony.superadapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
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
    }

    private <T extends View> T getView(int viewId) {
        View v = viewArray.get(viewId);

        if (null == v) {
            v = contentView.findViewById(viewId);
            viewArray.put(viewId, v);
        }
        return (T) v;
    }

    public CommonRecyclerViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
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
