package es;

import com.zsw.ZSWApplication;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
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
 * @description :ElasticSearchTest   deleteApi
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class EsDeleteApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        DeleteRequest request = new DeleteRequest(
                "posts",
                "doc",
                "1");
//        request.version(3);
//        request.versionType(VersionType.EXTERNAL);
        DeleteResponse deleteResponse = restHighLevelClient.delete(request);
        System.out.println(deleteResponse);
    }

}
