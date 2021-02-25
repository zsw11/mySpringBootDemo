import com.zsw.ZSWApplication;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description :ElasticSearchTest   search
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class SearchApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        SearchRequest searchRequest = new SearchRequest("posts");
        searchRequest.types("doc");// 添加索引参数
        // 搜索参数对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 添加一个match_all查询
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        // 添加查询条件
//        searchSourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
//        searchSourceBuilder.from(0);
//        searchSourceBuilder.size(5);
//        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
//        searchSourceBuilder.sort("_id");
        searchRequest.source(searchSourceBuilder);
        // 执行请求
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest);
        System.out.println(searchResponse);

    }

}
