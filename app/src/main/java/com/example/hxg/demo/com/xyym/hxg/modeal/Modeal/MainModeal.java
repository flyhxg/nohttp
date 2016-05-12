package com.example.hxg.demo.com.xyym.hxg.modeal.Modeal;

import android.content.Context;

import com.example.hxg.demo.com.xyym.hxg.Constract;
import com.example.hxg.demo.network.CallServer;
import com.example.hxg.demo.network.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.Request;

import org.json.JSONObject;

public class MainModeal {

    public  void showContent(Context context, String url,  HttpListener objectListener){
        Request<JSONObject> request = NoHttp.createJsonObjectRequest(url);
       request.setConnectTimeout(15*1000);
        request.addHeader("apikey", Constract.appkey);
       request.setRequestFailedReadCache(true);
        request.setTag(context);
        CallServer.getRequestInstance().add(context, 0, request, objectListener, false, false);
    }


}
