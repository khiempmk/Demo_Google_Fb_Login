package attt.oauth_demo.factory.facebook;

import attt.oauth_demo.utils.HttpConnector;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenFacebookGetter {
    public static String url_token = "https://graph.facebook.com/v2.12/oauth/access_token?" ;
    public static String getToken(String code){
        String url = url_token + "client_id=260777965283754" +
                "&redirect_uri=https://localhost:8080/AccessFacebook/login-facebook" +
                "&client_secret=395939d0e49cc34d013f843c78d2ba68" +
                "&code=" + code ;
        String response = new HttpConnector().sendGet(url);
        log.info(response);
         String token =  new JsonParser().parse(response).getAsJsonObject().get("access_token").getAsString();
        return token ;
    }
}
