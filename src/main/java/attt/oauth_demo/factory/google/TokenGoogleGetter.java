package attt.oauth_demo.factory.google;

import attt.oauth_demo.utils.HttpConnector;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

@Slf4j
public class TokenGoogleGetter {
    public static String url_token = "https://www.googleapis.com/oauth2/v4/token" ;
    public static String getToken(String code){
        String request_body = "grant_type=authorization_code&" +
                "code=" + code +
                "&client_id=244107158115-9rg048pe00o08a9bl1q3p4cbrn4g4096.apps.googleusercontent.com" +
                "&client_secret=4xn1t8X1ZOoHCrrI2cPyC8MJ" +
                "&redirect_uri=https://localhost:8080/AccessGoogle/login-google";
        String response = new HttpConnector().sendPost(url_token, request_body);
        log.info(response);
         String token =  new JsonParser().parse(response).getAsJsonObject().get("access_token").getAsString();
        return token ;
    }
}
