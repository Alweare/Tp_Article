package tp.eni.enistore.bll;

import org.springframework.stereotype.Service;
import tp.eni.enistore.bo.Article;

@Service
public class ResponseService <T> {
    public String code;
    public String message;
    public T data;




    public static <T> ResponseService buildResponse(String code, String message, T data) {
        ResponseService res = new ResponseService();
        res.code = code;
        res.message = message;
        res.data = data;

        return res;
    }

}
