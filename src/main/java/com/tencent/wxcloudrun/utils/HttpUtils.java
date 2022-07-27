package com.tencent.wxcloudrun.utils;

import com.tencent.wxcloudrun.controller.CounterController;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author suochao
 * @date 2022/7/27 2:11 下午
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(CounterController.class);

    ;

    /**
     * get 请求
     * @param url
     * @return
     */
    public static String get(String url) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            logger.info("access url= {},response = {}", url, response);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //请求体内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                //相当于关闭浏览器
                httpclient.close();
            } catch (Exception e) {
                //空
            }
        }
        return null;
    }


}
