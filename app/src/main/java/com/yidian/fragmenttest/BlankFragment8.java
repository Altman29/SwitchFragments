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
public class BlankFragment8 extends Fragment {

    private Button btn_back,btn_enter;
    private FragmentTestListener listener;
    public BlankFragment8() {
        // Required empty public constructor
    }


    public void setListener(FragmentTestListener listener){
        this.listener=listener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View retView=inflater.inflate(R.layout.fragment_blank_fragment8, container, false);

        btn_back= (Button) retView.findViewById(R.id.btnback_fragment8);
        btn_enter= (Button) retView.findViewById(R.id.btnenter_fragment8);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentBack(BlankFragment8.this,"BlankFragment7",new Bundle());

            }
        });
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentAdd(BlankFragment8.this,"BlankFragment9",new Bundle());
            }
        });
        return retView;
    }


}
