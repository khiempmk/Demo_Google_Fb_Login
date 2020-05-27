package attt.oauth_demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    public String code ;
    public String scope;
    public int authuser ;
    public String prompt;
}
