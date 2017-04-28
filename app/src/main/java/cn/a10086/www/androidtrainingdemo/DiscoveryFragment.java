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
 * @time 2017/4/28  10:23
 * @desc ${TODD}
 */
public class DiscoveryFragment extends Fragment {


    private String from;

    public static Fragment newInstance(String from) {

        DiscoveryFragment discoveryFragment = new DiscoveryFragment();

        Bundle bundle = new Bundle();
        bundle.putString("from", from);

        discoveryFragment.setArguments(bundle);

      return  discoveryFragment;

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

        View view  = inflater.inflate(R.layout.fragment_discover, null);
        TextView textView = (TextView) view.findViewById(R.id.title_from);
        TextView content = (TextView) view.findViewById(R.id.dis_fragment_content);
        textView.setText(from);
        content.setText("DiscoverFragment");
        return view;
    }
}
