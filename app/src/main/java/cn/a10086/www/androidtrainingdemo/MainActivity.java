package cn.a10086.www.androidtrainingdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Fragment[] mFragments;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mFragments = FragmentFrac.getFragments("TabLayout Tab");

        initView();


    }

    private void initView() {

        mTabLayout = (TabLayout) findViewById(R.id.tab_bottom);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                当Tab被选中的时候
                onTabItemSelected(tab.getPosition());

                for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                    View view = mTabLayout.getTabAt(i).getCustomView();
                    ImageView icon = (ImageView) view.findViewById(R.id.tab_content_image);
                    TextView text = (TextView) view.findViewById(R.id.tab_content_text);

                    if(i == tab.getPosition()){
                        icon.setImageResource(FragmentFrac.mTabResPressed[i]);
                        text.setTextColor(getResources().getColor(android.R.color.black));
                    }else{
                        icon.setImageResource(FragmentFrac.mTabImage[i]);
                        text.setTextColor(getResources().getColor(android.R.color.darker_gray));
                    }


                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for(int i=0;i<mFragments.length;i++){
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(FragmentFrac.getTabView(this,i)));
        }


    }

    private void onTabItemSelected(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = mFragments[0];
                break;
            case 1:
                fragment = mFragments[1];
                break;
            case 2:
                fragment = mFragments[2];
                break;
            case 3:
                fragment = mFragments[3];
                break;
        }
        if (fragment != null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.home_content, fragment).commit();

        }


    }
}
