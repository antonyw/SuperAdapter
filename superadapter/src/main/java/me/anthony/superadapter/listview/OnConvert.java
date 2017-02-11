package me.anthony.superadapter.listview;

/**
 * Created by Anthony on 2017/2/11.
 */

public interface OnConvert<T> {
    void convert(CommonListViewHolder viewHolder, T t);
}
