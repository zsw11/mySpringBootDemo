import com.zsw.ZSWApplication;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description :ElasticSearchTest   getApi
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class EsGetApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        /*get request */
        GetRequest getRequest = new GetRequest("posts", "doc", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest);
        String index = getResponse.getIndex();
        String type = getResponse.getType();
        String id = getResponse.getId();
        System.out.println(getResponse);
//        if (getResponse.isExists()) {
//            long version = getResponse.getVersion();
//            String sourceAsString = getResponse.getSourceAsString();
//            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
//            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
//            System.out.println("version:"+version+",sourceAsString:"+sourceAsString+",sourcemap:"+sourceAsMap+",sourceAsBytes:"+sourceAsBytes);
//        } else {
//
//        }
        System.out.println(index+"-----"+type+"----------"+id+"------------");



    }

}
