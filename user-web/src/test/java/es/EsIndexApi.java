package es;

import com.zsw.ZSWApplication;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description :ElasticSearchTest   index api
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class EsIndexApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
//        //创建索引请求
//        IndexRequest request = new IndexRequest(
//                "posts",
//                "doc",
//                "1");
//        String jsonString = "{" +
//                "\"user\":\"kimchy\"," +
//                "\"postDate\":\"2013-01-30\"," +
//                "\"message\":\"trying out Elasticsearch\"" +
//                "}";
//
//        request.source(jsonString, XContentType.JSON);
//        // 执行保存操作
//        IndexResponse indexResponse = restHighLevelClient.index(request);
//        // 响应数据
//                System.out.println(indexResponse.getIndex());
//                System.out.println(indexResponse.getType());

        //方式二
        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "zsw");
        jsonMap.put("postDate", new LocalDate());
        jsonMap.put("message", "测试index api");
        IndexRequest indexRequest = new IndexRequest("jd_goods", "ParseDemo").source(jsonMap);
        IndexResponse indexResponse1 = restHighLevelClient.index(indexRequest);
        DocWriteResponse.Result result = indexResponse1.getResult();
        System.out.println(result);


    }

}
