package attt.oauth_demo.control;

import attt.oauth_demo.factory.facebook.InfoFacebookGetter;
import attt.oauth_demo.factory.facebook.TokenFacebookGetter;
import attt.oauth_demo.factory.google.InfoGoogleGetter;
import attt.oauth_demo.factory.google.TokenGoogleGetter;
import attt.oauth_demo.model.InfoModel;
import attt.oauth_demo.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {
    @RequestMapping(value = "/index")
    public String index(){
        return "index" ;
    }
    @GetMapping("/AccessGoogle/login-google")
    public String loginGoogle(Response model, HttpServletRequest request) {
        log.info(model.code);
        String token = TokenGoogleGetter.getToken(model.code);
        InfoModel info = InfoGoogleGetter.get(token);
        request.setAttribute("id", info.getId());
        request.setAttribute("email", info.getEmail());
        request.setAttribute("picture", info.getPicture());
        return "welcome";
    }

    @GetMapping("/AccessFacebook/login-facebook")
    public String loginFacebook(Response model, HttpServletRequest request) {
        log.info(model.code);
        String token = TokenFacebookGetter.getToken(model.code);
        InfoModel info = InfoFacebookGetter.get(token);
        request.setAttribute("id", info.getId());
        request.setAttribute("name", info.getName());
        return "welcome";
    }
}
