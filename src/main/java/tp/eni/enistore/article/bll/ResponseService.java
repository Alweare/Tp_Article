package tp.eni.enistore.article.bll;

import org.springframework.stereotype.Service;

@Service
public class ResponseService <T> {
    public String code;
    public String message;
    public T data;




    public static <T> ResponseService <T> buildResponse(String code, String message, T data) {
        ResponseService<T> res = new ResponseService<>();
        res.code = code;
        res.message = message;
        res.data = data;

        return res;
    }

}
