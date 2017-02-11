package me.anthony.superadapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Anthony on 2017/2/11.
 */

public class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<CommonRecyclerViewHolder> {

    private Context context;

    protected List<T> data;

    protected int layout;

    private OnItemClickListener clickListener;
    private OnItemLongClickListener longClickListener;
    private OnConvert<T> convert;

    public CommonRecyclerAdapter(Context context, List<T> data, int layout, OnConvert<T> convert) {
        this.context = context;
        this.data = data;
        this.layout = layout;
        this.convert = convert;
    }

    @Override
    public CommonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);
        return new CommonRecyclerViewHolder(v, clickListener, longClickListener);
    }

    @Override
    public void onBindViewHolder(CommonRecyclerViewHolder holder, int position) {
        convert.convert(holder, data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
}
