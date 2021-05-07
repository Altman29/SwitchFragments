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
public class BlankFragment9 extends Fragment {


    private Button btn_back;
    private FragmentTestListener listener;
    public BlankFragment9() {
        // Required empty public constructor
    }


    public void setListener(FragmentTestListener listener){
        this.listener=listener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View retView=inflater.inflate(R.layout.fragment_blank_fragment9, container, false);

        btn_back= (Button) retView.findViewById(R.id.btnback_fragment9);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentBack(BlankFragment9.this,"BlankFragment8",new Bundle());

            }
        });

        return retView;
    }



}
