package attt.oauth_demo.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.util.concurrent.TimeUnit;
@Slf4j
public class HttpConnector {
    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .readTimeout(10000,TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(true)
            .build() ;
    public String sendPost(String url , String body) {
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), body);
            Request request = new Request.Builder().url(url)
                    .header("Connection", "close")
                    .post(requestBody).build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
    public  String sendGet(String url){
        try{
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            return  response.body().string();
        } catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return null;
    }
}
