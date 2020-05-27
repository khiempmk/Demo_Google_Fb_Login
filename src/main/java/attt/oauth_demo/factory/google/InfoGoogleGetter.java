package attt.oauth_demo.factory.google;

import attt.oauth_demo.model.InfoModel;
import attt.oauth_demo.utils.HttpConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InfoGoogleGetter {
    private static String URL_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static InfoModel get(String token){
        try{
            String url =  URL_INFO + token ;
            String response = new HttpConnector().sendGet(url);
            log.info(response);
            InfoModel model = new ObjectMapper().readValue(response, InfoModel.class);
            return model;
        } catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return null;
    }
}
