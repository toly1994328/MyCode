package com.toly1994.mycode.app;

import com.toly1994.mycode.R;
import com.toly1994.mycode.bean.IconItem;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/13 0013:19:31<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class Cons {
    //        public static final String BASE_URL = "http://192.168.10.114:8089/";
//    public static final String BASE_URL = "http://192.168.43.60:8089/";
    public static final String BASE_URL = "http://toly1994.com:8089/";
//    public static final String API = "http://192.168.10.114:8089/";

    public static final String TOKEN = "";

    public static final IconItem[] BNB_ITEM = new IconItem[]{
            new IconItem("Android", R.drawable.icon_android, R.color.color4Android),
            new IconItem("Spring", R.drawable.icon_spring_boot, R.color.color4SpringBoot),
            new IconItem("React", R.drawable.icon_react, R.color.color4React),
            new IconItem("编程随笔", R.drawable.icon_note, R.color.color4Note),
            new IconItem("系列文章", R.drawable.icon_code, R.color.color4Ser),
    };

}
