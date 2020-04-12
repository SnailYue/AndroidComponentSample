package com.snail.componenthome.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.snail.componentbasic.base.BaseActivity;
import com.snail.componentbasic.base.BaseFragment;
import com.snail.componentbasic.util.Constance;
import com.snail.componenthome.R;

@Route(path = Constance.HomeFragment)
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getName();
    private FrameLayout layout;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        layout = view.findViewById(R.id.fl_view);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: click");
                ((BaseActivity) getActivity()).showFragment(1);
            }
        });
        return view;
    }
}
