package com.zsw.elasticSearch;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description :ElasticSearchTest
 */
@SpringBootTest
public class ElasticSearchTest {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        //创建索引请求
        IndexRequest request = new IndexRequest(
                "posts",
                "doc",
                "1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        // 执行保存操作
        IndexResponse indexResponse = restHighLevelClient.index(request);
//        restHighLevelClient.indexAsync(request, new ActionListener<IndexResponse>() {
//            @Override
//            public void onResponse(IndexResponse indexResponse) {
//
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                System.out.println("失败");
//            }
//        });
        // 响应数据
                System.out.println(indexResponse.getIndex());
                System.out.println(indexResponse.getType());
    }

}
