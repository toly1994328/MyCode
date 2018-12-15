package com.toly1994.presenter;

import com.toly1994.mycode.bean.ErrorEnum;
import com.toly1994.mycode.bean.ResultBean;
import com.toly1994.mycode.model.Callback;
import com.toly1994.mycode.model.INoteModel;
import com.toly1994.mycode.model.NoteModel;
import com.toly1994.mycode.view.INoteView;

import java.util.List;
import java.util.Map;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:13:57<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：控制层
 */
public class PagerPresenter extends BasePresenter implements IPresenter<ResultBean.NoteBean> {
    private INoteView<ResultBean.NoteBean> mNoteView;
    private INoteModel<ResultBean.NoteBean> mModel;
    private Callback<ResultBean.NoteBean> mCallback;


    public PagerPresenter(INoteView<ResultBean.NoteBean> noteView) {
        mNoteView = noteView;
        mModel = new NoteModel();
        initCallBack();

    }

    private void initCallBack() {
        mCallback = new Callback<ResultBean.NoteBean>() {
            @Override
            public void onStartLoad() {
                mNoteView.loading();
            }

            @Override
            public void onSuccess(List<ResultBean.NoteBean> dataList) {
                mNoteView.reader(dataList);
                mNoteView.loaded();
            }

            @Override
            public void onError(ErrorEnum e) {
                mNoteView.error(e);
                mNoteView.loaded();
            }
        };
    }

    @Override
    public void updateByArea(String area, int offset, int count) {

        mModel.getDataByArea(mCallback, area, offset, count);

    }


    @Override
    public void updateByName(String name, int offset, int count) {
        mModel.getDataByName(mCallback, name, offset, count);
    }

    @Override
    public void addItem(Map<String, String> params) {
        mModel.insertModel(params);
    }
}
