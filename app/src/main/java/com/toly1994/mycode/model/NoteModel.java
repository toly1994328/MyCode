package com.toly1994.mycode.model;

import com.toly1994.mycode.app.InitRetrofit;
import com.toly1994.mycode.app.NetUtil;
import com.toly1994.mycode.app.NoteApi;
import com.toly1994.mycode.bean.ErrorEnum;
import com.toly1994.mycode.bean.ResultBean;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:13:44<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class NoteModel implements INoteModel<ResultBean.NoteBean> {

    private static final String TAG = "NoteModel";
    private NoteApi mNoteApi;

    public NoteModel() {
        mNoteApi = InitRetrofit.getInstance().getRetrofit().create(NoteApi.class);
    }

    @Override
    public void getData(Callback<ResultBean.NoteBean> callback, int offset, int page) {
        callback.onStartLoad();
        doSubscribe(callback, mNoteApi.findAll(offset, page));
    }

    /**
     * 执行api返回的Observable
     *
     * @param callback 回调函数
     * @param apiAll   Observable
     */
    private void doSubscribe(Callback<ResultBean.NoteBean> callback, Observable<ResultBean> apiAll) {
        apiAll.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultBean resultBean) {
                        if (callback != null) {
                            callback.onSuccess(resultBean.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callback != null) {
                            callback.onError(ErrorEnum.NET_LINK);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void getDataByArea(Callback<ResultBean.NoteBean> callback, String area, int offset, int page) {

        if (!NetUtil.isNetworkConnected()) {
            callback.onError(ErrorEnum.NO_NET);
        }

        callback.onStartLoad();
        doSubscribe(callback, mNoteApi.findByArea(area, offset, page));

    }

    @Override
    public void getDataByName(Callback<ResultBean.NoteBean> callback, String name, int offset, int page) {
        if (!NetUtil.isNetworkConnected()) {
            callback.onError(ErrorEnum.NO_NET);
        }

        callback.onStartLoad();
        doSubscribe(callback, mNoteApi.findByName(name, offset, page));

    }

    @Override
    public void insertModel(Map<String, String> params) {
        doSubscribe(null, mNoteApi.insert(params));
    }
}
