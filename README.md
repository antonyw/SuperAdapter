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
    compile 'com.github.antonyw:superadapter:1.0'
}
```

##### For RecyclerView
```Java
CommonRecyclerAdapter<> adapter = new CommonRecyclerAdapter<>(context, data, layout, new OnConvert<>() {
    @Override
    public void convert(CommonRecyclerViewHolder viewHolder, T t) {

    }
});
```
