package cn.a10086.www.androidtrainingdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author
 * @time 2017/4/28  10:33
 * @desc ${TODD}
 */
public class AttentionFragment  extends Fragment {

    private String from;

    public static Fragment newInstance(String from) {

        AttentionFragment attentionFragment = new AttentionFragment();

        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        attentionFragment.setArguments(bundle);

        return  attentionFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null) {

            from = getArguments().getString("from");

        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_attention, null);
        TextView textView = (TextView) view.findViewById(R.id.title_from);
        TextView content = (TextView) view.findViewById(R.id.atten_fragment_content);
        textView.setText(from);
        content.setText("AttentionFragment");
        return view;
    }



}
