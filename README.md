# SuperAdapter
Adapter for RecyclerView and ListView

### Usage
#### Step 1
Add it in your root build.gradle at the end of repositories
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

#### Step 2
Add the dependency
```
dependencies {
    compile 'com.github.antonyw:superadapter:1.1'
}
```

##### For RecyclerView
```java
new CommonRecyclerAdapter<>(context, data, layout, new OnConvert<T>() {
    @Override
    public void convert(CommonRecyclerViewHolder viewHolder, T t) {
        viewHolder.setText(resourceId,"xxx");
    }
});
```

_Add click listener and long click listener for RecyclerView item_
```java
adapter.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(View view, int position) {
        //click
    }
});
```

##### For ListView
```java
new CommonListAdapter<>(context, data, layout, new OnConvert<T>() {
    @Override
    public void convert(CommonListViewHolder viewHolder, T t) {
        //do something for item
    }
})
```