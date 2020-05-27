package attt.oauth_demo.factory.facebook;

import attt.oauth_demo.model.InfoModel;
import attt.oauth_demo.utils.HttpConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InfoFacebookGetter {
    private static String URL_INFO = "https://graph.facebook.com/me?access_token=";
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
