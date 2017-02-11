package me.anthony.superadapter.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Anthony on 2017/2/11.
 */

public class CommonListAdapter<T> extends BaseAdapter {

    private Context mContext;
    private List<T> mData;
    private int layoutId;
    private OnConvert convert;

    public CommonListAdapter(Context context, List<T> data, int layoutId, OnConvert convert) {
        this.mContext = context;
        this.mData = data;
        this.layoutId = layoutId;
        this.convert = convert;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonListViewHolder viewHolder = CommonListViewHolder.get(mContext, convertView, parent, layoutId, position);
        convert.convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }
}
