package demo.feature.user;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.common.Util;
import demo.model.Task;
import lombok.Data;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SNAKE_CASE;

/**
 * @author yangqiang
 */
public class UserApp1 {
    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient().newBuilder().build();
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setPropertyNamingStrategy(SNAKE_CASE);
    }

    private <T> T parseBody(String url, ResponseBody body, Class<T> t) {
        if (body == null) {
            throw new RuntimeException(url + " response is null");
        } else {
            try {
                return OBJECT_MAPPER.readValue(body.string(), t);
            } catch (IOException e) {
                throw new RuntimeException("JSON反序列化信控算法返回的数据失败", e);
            }
        }
    }

    protected Task calculate() {
        String url =  "http://localhost:8080/api/task";
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody requestBody = null;
        Request request = new Request.Builder()
                .url(url)
                .method("GET", requestBody)
                .build();

        Response response;
        try {
            response = OK_HTTP_CLIENT.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException("请求信控算法服务出错", e);
        }
        ResponseBody body;
        if (response.code() != 200) {
            throw new RuntimeException("请求信控算法服务返回码异常：" + response.code());
        }
        return parseBody(url, response.body(), Task.class);
    }

    public static void main(String[] args) {
        UserApp1 app1 = new UserApp1();
        Util.print(app1.calculate());
    }
}
