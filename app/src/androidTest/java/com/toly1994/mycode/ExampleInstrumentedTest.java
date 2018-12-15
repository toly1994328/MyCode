package com.toly1994.mycode;

import android.support.test.runner.AndroidJUnit4;

import com.toly1994.mycode.bean.ErrorEnum;
import com.toly1994.mycode.bean.ResultBean;
import com.toly1994.mycode.model.Callback;
import com.toly1994.mycode.model.NoteModel;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void getAllData() {
        NoteModel model = new NoteModel();
        model.getData(new Callback<ResultBean.NoteBean>() {
            @Override
            public void onStartLoad() {
            }

            @Override
            public void onSuccess(List<ResultBean.NoteBean> dataList) {
                assertEquals(12, dataList.size());
            }

            @Override
            public void onError(ErrorEnum e) {

            }
        }, 0, 12);
    }

    @Test
    public void getDataByName() {
        NoteModel model = new NoteModel();
        model.getDataByName(new Callback<ResultBean.NoteBean>() {
            @Override
            public void onStartLoad() {
            }

            @Override
            public void onSuccess(List<ResultBean.NoteBean> dataList) {
                assertEquals(12, dataList.size());
            }

            @Override
            public void onError(ErrorEnum e) {

            }
        }, "A", 0, 12);
    }
}
