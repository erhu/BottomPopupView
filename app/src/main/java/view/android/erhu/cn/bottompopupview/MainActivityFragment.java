package view.android.erhu.cn.bottompopupview;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final int SHEET_HEIGHT = 300;
    public static final int HEADER_HEIGHT = 45;

    private BottomPopupView mPopupView;
    private View mContentContainer;
    private View mHeader;
    private View mContent;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mPopupView = (BottomPopupView) view.findViewById(R.id.popup_view_root);
        mContentContainer = LayoutInflater.from(getContext()).inflate(R.layout.bottom_popup_content, null);

        mHeader = mContentContainer.findViewById(R.id.bottom_pop_up_header);
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

        mPopupView.init(mContentContainer, dp2px(SHEET_HEIGHT), dp2px(HEADER_HEIGHT));

    }

    private int dp2px(int dp) {
        Resources r = getContext().getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }
}
