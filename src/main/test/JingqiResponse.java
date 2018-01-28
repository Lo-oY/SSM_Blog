import java.util.Map;

/**
 * Created by cilu on 2017/12/8.
 */
public class JingqiResponse {
    private Map<String,Object> head;
    private Map<String,Object> body;

    public Map<String, Object> getHead() {
        return head;
    }

    public void setHead(Map<String, Object> head) {
        this.head = head;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "JingqiResponse{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
