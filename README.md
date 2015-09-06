# BottomPopupView
## Preview
![](https://github.com/erhu/BottomPopupView/blob/master/resources/demo.gif)

## How to Use
xml
```xml
<cn.erhu.android.bottompopup.BottomPopupView
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:id="@+id/popup_view_root"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#CC9933"/>
```

java
```java
// Init popupView.
mPopupView = (BottomPopupView) view.findViewById(R.id.popup_view_root);
mPopupView.setPopListener(new BottomPopupView.PopListener() {
    @Override
    public void onOpened() { ... }
    @Override
    public void onClosed() { ... }
});

// Init ContentView.
mContentContainer = LayoutInflater.from(getContext()).inflate(R.layout.bottom_popup_content, null);
mHeader = (Button) mContentContainer.findViewById(R.id.bottom_pop_up_header);
mHeader.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (mPopupView.isOpened()) {
            mPopupView.popDown();
        } else {
            mPopupView.popup();
        }
    }
});

mContent = mContentContainer.findViewById(R.id.bottom_pop_up_content);
mContent.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, dp2px((SHEET_HEIGHT - HEADER_HEIGHT))));

// Add ContentView to PopupView and set height of ContentView And Header.
mPopupView.init(mContentContainer, dp2px(SHEET_HEIGHT), dp2px(HEADER_HEIGHT));
```
