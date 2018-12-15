package com.toly1994.mycode;

import com.toly1994.mycode.bean.ErrorEnum;
import com.toly1994.mycode.bean.ResultBean;
import com.toly1994.mycode.model.Callback;
import com.toly1994.mycode.model.NoteModel;

import org.junit.Test;

import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        NoteModel model = new NoteModel();
        model.getData(new Callback<ResultBean.NoteBean>() {
            @Override
            public void onStartLoad() {

            }

            @Override
            public void onSuccess(List<ResultBean.NoteBean> dataList) {
                System.out.println(dataList.get(0).getName());
//                assertEquals(12, dataList.size());

            }

            @Override
            public void onError(ErrorEnum e) {

            }
        }, 0, 12);
    }
}