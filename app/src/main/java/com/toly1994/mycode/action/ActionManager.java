package com.toly1994.mycode.action;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.toly1994.mycode.R;
import com.toly1994.mycode.bean.ResultBean;
import com.toly1994.mycode.view.widget.AlphaImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/15 0015:9:14<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class ActionManager {
    /**
     * 搜索
     *
     * @param textView
     * @param view
     * @param callback
     */
    public static void doSearch(TextView textView, AlphaImageView view, IAction callback) {
        view.setOnAlphaListener(v -> {
            callback.doSearch(textView.getText().toString());
        });
    }

    public static void doAdd(Context context, IAction callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add, null);
        EditText title = dialogView.findViewById(R.id.et_upload_title);
        EditText url = dialogView.findViewById(R.id.et_upload_path);
        DatePicker cost_date = dialogView.findViewById(R.id.cost_date);

        builder.setTitle("添加文章");
        builder.setView(dialogView);
        builder.setPositiveButton("确定", (dialog, which) -> {
            String createTime = cost_date.getYear() + "-" + (cost_date.getMonth() + 1) + "-" + cost_date.getDayOfMonth();

            ResultBean.NoteBean noteBean = new ResultBean.NoteBean();
            String name = title.getText().toString();
            String jianshuUrl = url.getText().toString();
            String imgUrl = "8a11d27d58f4c1fa4488cf39fdf68e76.png";
            noteBean.setImgUrl(imgUrl);

            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("type","C");
            hashMap.put("name",name);
            hashMap.put("jianshuUrl",jianshuUrl);
            hashMap.put("juejinUrl","---");
            hashMap.put("imgUrl",imgUrl);
            hashMap.put("createTime",createTime);
            hashMap.put("info","hh");
            hashMap.put("area","A");
            hashMap.put("localPath","---");

            callback.doAdd(hashMap);
        });

        builder.setNegativeButton("取消", null);
        builder.create().show();
    }
}
