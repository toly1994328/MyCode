package com.toly1994.mycode.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.toly1994.mycode.R;
import com.toly1994.mycode.action.ActionAdapter;
import com.toly1994.mycode.action.ActionManager;
import com.toly1994.mycode.app.Cons;
import com.toly1994.mycode.app.compat.CompatNavigationBar;
import com.toly1994.mycode.bean.ErrorEnum;
import com.toly1994.mycode.bean.IconItem;
import com.toly1994.mycode.bean.ResultBean;
import com.toly1994.mycode.view.adapter.HomeAdapter;
import com.toly1994.mycode.view.widget.AlphaImageView;
import com.toly1994.presenter.PagerPresenter;

import java.util.List;
import java.util.Map;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:8:05<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class HomePagerView extends AppCompatActivity implements INoteView<ResultBean.NoteBean> {
    private RecyclerView mHomeRv;
    private BottomNavigationBar mIdBnb;
    private Toolbar mToolbar;

    private String area = "A";
    private int count = 1000;

    private SwipeRefreshLayout mIdSrl;

    private ActionBarDrawerToggle mABDT;
    DrawerLayout mIdDlRoot;
    private FloatingActionButton mIdFab;

    private boolean isOpen;
    private BottomSheetBehavior<RelativeLayout> mBottomSheetBehavior;
    RelativeLayout mBottomSheet;

    private PagerPresenter mPagerPresenter;
    private CollapsingToolbarLayout mIdCtlBar;
    private ImageView mIdIvHead;
    private AlphaImageView mIdBtnSearch;
    private EditText mIdETSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_pager);
        findViews();
        bnbInit();
        setSupportActionBar(mToolbar);
        CompatNavigationBar.handle(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mPagerPresenter = new PagerPresenter(this);
        mPagerPresenter.updateByArea(area, 0, count);

        drawerLayoutToggle();
        fabClickAndSheet();
        initLoading();


        ActionManager.doSearch(mIdETSearch, mIdBtnSearch, new ActionAdapter() {
            @Override
            public void doSearch(String str) {
                mPagerPresenter.updateByName(str, 0, 1000);
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                isOpen = false;
            }
        });

    }

    private void drawerLayoutToggle() {
        mABDT = new ActionBarDrawerToggle(
                this, mIdDlRoot, mToolbar, R.string.str_open, R.string.str_close);
        mIdDlRoot.addDrawerListener(mABDT);
    }

    private void initLoading() {
        //每转一圈，换一种颜色
        mIdSrl.setColorSchemeColors(
                0xffF60C0C,//红
                0xffF3B913,//橙
                0xffE7F716,//黄
                0xff3DF30B,//绿
                0xff0DF6EF,//青
                0xff0829FB,//蓝
                0xffB709F4//紫
        );

        mIdSrl.setOnRefreshListener(() -> {
            mPagerPresenter.updateByArea(area, 0, count);
        });
    }


    @Override
    public void reader(List<ResultBean.NoteBean> dataList) {
        HomeAdapter ListAdapter = new HomeAdapter(dataList);
        mHomeRv.setAdapter(ListAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        GridLayoutManager gm = new GridLayoutManager(this, 2);
        mHomeRv.setLayoutManager(gm);
    }


    @Override
    public void error(ErrorEnum e) {
        switch (e) {
            case NO_NET:
                Toast.makeText(this, "网络异常", Toast.LENGTH_SHORT).show();
        }
    }


    private void bnbInit() {
        IconItem[] items = Cons.BNB_ITEM;
        for (IconItem item : items) {
            mIdBnb.addItem(new BottomNavigationItem(item.getIconId(), item.getInfo())
                    .setActiveColorResource(item.getColor()));
        }
        mIdBnb.initialise();

        mIdBnb.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        area = "A";
                        mIdCtlBar.setTitle("Android技术栈");
                        mIdIvHead.setImageResource(R.mipmap.bg_android);
                        break;
                    case 1:
                        area = "SB";
                        mIdCtlBar.setTitle("SpringBoot技术栈");
                        mIdIvHead.setImageResource(R.mipmap.bg_springboot);
                        break;
                    case 2:
                        area = "Re";
                        mIdCtlBar.setTitle("React技术栈");
                        mIdIvHead.setImageResource(R.mipmap.bg_react);

                        break;
                    case 3:
                        area = "Note";
                        mIdCtlBar.setTitle("随笔编程杂谈录");
                        mIdIvHead.setImageResource(R.mipmap.menu_bg);

                        break;
                    case 4:
                        area = "A";
                        mIdCtlBar.setTitle("系列文章");
                        break;

                }
                mPagerPresenter.updateByArea(area, 0, count);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public void loading() {
        mIdSrl.setRefreshing(true);
    }

    @Override
    public void loaded() {
        mIdSrl.setRefreshing(false);

    }

    private void findViews() {
        mHomeRv = findViewById(R.id.id_rv_bnb);
        mIdBnb = findViewById(R.id.id_bnb);
        mToolbar = findViewById(R.id.home_tool_bar);
        mIdDlRoot = findViewById(R.id.id_dl_root);
        mIdFab = findViewById(R.id.id_fab_b);
        mBottomSheet = findViewById(R.id.bottom_sheet);
        mIdSrl = findViewById(R.id.id_srl);
        mIdCtlBar = findViewById(R.id.ctl_toolbar);
        mIdIvHead = findViewById(R.id.iv_header);
        mIdBtnSearch = findViewById(R.id.id_btn_search);
        mIdETSearch = findViewById(R.id.id_et_search_str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                ActionManager.doAdd(this, new ActionAdapter() {
                    @Override
                    public void doAdd(Map<String, String> params) {
                        mPagerPresenter.addItem(params);
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mABDT.syncState();//加了这个才有酷炫的按钮变化
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPagerPresenter.onDestroy();
    }

    /**
     * BottomSheet与FloatingActionButton的结合
     */
    private void fabClickAndSheet() {
        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
        mIdFab.setOnClickListener(v -> {
            if (isOpen) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
            isOpen = !isOpen;
        });
    }


}
