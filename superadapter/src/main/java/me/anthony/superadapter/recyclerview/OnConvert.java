package me.anthony.superadapter.recyclerview;

/**
 * Created by Anthony on 2017/2/11.
 */

public interface OnConvert<T> {
    void convert(CommonRecyclerViewHolder viewHolder, T t);
}
