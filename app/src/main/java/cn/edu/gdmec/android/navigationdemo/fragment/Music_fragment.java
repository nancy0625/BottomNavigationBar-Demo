package cn.edu.gdmec.android.navigationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.gdmec.android.navigationdemo.R;

/**
 * Created by asus on 2017/12/7.
 */

public class Music_fragment extends Fragment {
    public Music_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.music_fragment,container,false);
    }
}
