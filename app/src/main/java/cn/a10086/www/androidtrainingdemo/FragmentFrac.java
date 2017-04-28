package cn.a10086.www.androidtrainingdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author
 * @time 2017/4/27  22:11
 * @desc ${TODD}
 */
public class FragmentFrac {

    public static final int[] mTabResPressed = new int[]{R.drawable.ic_tab_strip_icon_feed_selected, R.drawable.ic_tab_strip_icon_category_selected, R.drawable.ic_tab_strip_icon_pgc_selected, R.drawable.ic_tab_strip_icon_profile_selected};
    public static final int[] mTabImage = {R.drawable.tab_home_selector, R.drawable.tab_discovery_selector, R.drawable.tab_attention_selector, R.drawable.tab_profile_selector};
    public static final String[] mTabTitle = new String[]{"首页", "发现", "关注", "我的"};

    //    创建所有的fragment操作
    public static Fragment[] getFragments(String from) {

        Fragment[] fragmens = new Fragment[4];
        fragmens[0] = HomeFragment.newInstance(from);
        fragmens[1] = DiscoveryFragment.newInstance(from);
        fragmens[2] = AttentionFragment.newInstance(from);
        fragmens[3] = MineFragment.newInstance(from);
        return fragmens;
    }

//   根据位置  获取对应Tab显示的内容


    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(FragmentFrac.mTabImage[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
