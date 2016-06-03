/*
 * Copyright © YOLANDA. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.hxg.demo.network;


import com.example.hxg.demo.com.xyym.hxg.util.GsonUtil;
import com.yolanda.nohttp.Headers;import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.JsonObjectRequest;
import com.yolanda.nohttp.rest.RestRequest;
import com.yolanda.nohttp.rest.StringRequest;

/**
 * <p>自定义请求对象.</p>
 * Created in Feb 1, 2016 8:53:17 AM.
 *
 * @author YOLANDA;
 */
public class FastJsonRequest<E> extends RestRequest<E> {
    private Class<E> clazz;
    public FastJsonRequest(String url,Class<E> clazz) {
        this(url, RequestMethod.GET,clazz);


    }

    public FastJsonRequest(String url, RequestMethod requestMethod,Class<E> clazz) {
        super(url, requestMethod);
        this.clazz = clazz;
    }

    @Override
    public E parseResponse(String url, Headers responseHeaders, byte[] responseBody) {
        String result = StringRequest.parseResponseString(url, responseHeaders, responseBody);

        try {

           return GsonUtil.fromJson(result,clazz);
        } catch (Throwable e) {
            // 这里默认的错误可以定义为你们自己的协议
            E instance=null;
            try {
                instance = clazz.newInstance();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
            return instance;
        }

    }

    @Override
    public String getAccept() {
        // 告诉服务器你接受什么类型的数据, 会添加到请求头的Accept中
        return JsonObjectRequest.ACCEPT;
    }

}
