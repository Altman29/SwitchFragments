package com.yidian.fragmenttest;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment4 extends Fragment {


    private Button btn_enter;
    private FragmentTestListener listener;
    public BlankFragment4() {
        // Required empty public constructor
    }


    public void setListener(FragmentTestListener listener){
        this.listener=listener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View retView=inflater.inflate(R.layout.fragment_blank_fragment4, container, false);

        btn_enter= (Button) retView.findViewById(R.id.btnenter_fragment4);
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentAdd(BlankFragment4.this,"BlankFragment5",new Bundle());
            }
        });
        return retView;
    }

}
