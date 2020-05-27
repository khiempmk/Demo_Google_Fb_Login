package attt.oauth_demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class InfoModel {
    private String id ;
    private String email;
    private boolean verified_email ;
    private String name ;
    private String given_name;
    private String family_name;
    private String link ;
    private String picture;
}
