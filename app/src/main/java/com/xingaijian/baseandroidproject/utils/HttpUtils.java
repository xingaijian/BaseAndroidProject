package com.xingaijian.baseandroidproject.utils;

import android.content.Context;
import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

/**
 * Created by xingaijian on 2018/5/31.
 * Email：1124462335@qq.com
 * OkGo网络请求工具类
 */

public class HttpUtils {

    /**
     * 网络请求结果回调
     */
    public interface httpCallBack{
        void doCallBack(Response<String> response);
    }

    /**
     *
     * post网络请求提取
     *
     * @param context 上下文
     * @param url      请求接口地址
     * @param httpParams  请求携带的参数
     * @param httpCallBack  成功回调的结果
     */
    public void postHttp(Context context, String url, HttpParams httpParams, final httpCallBack httpCallBack){
        OkGo.<String>post(url)
                .headers("","")
                .params(httpParams)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.i("postHttp", "onSuccess: "+response);
                        httpCallBack.doCallBack(response);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }
}
