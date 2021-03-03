package es;

import com.zsw.ZSWApplication;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description :ElasticSearchTest   updateApi
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class EsUpdateApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("updated", new Date());
        jsonMap.put("reason", "daily update");
        UpdateRequest request = new UpdateRequest("posts", "doc", "1")
                .doc(jsonMap);
        UpdateResponse updateResponse = restHighLevelClient.update(request);
        System.out.println(updateResponse);
    }

}
