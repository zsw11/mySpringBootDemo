package es;

import com.zsw.ZSWApplication;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description : 批量请求
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class EsBulkApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        BulkRequest request = new BulkRequest();
        request.add(new UpdateRequest("posts", "doc", "1")
                .doc(XContentType.JSON,"field", "foo"));
        request.add(new IndexRequest("posts", "doc", "4")
                .source(XContentType.JSON,"field", "bar"));
        request.add(new IndexRequest("posts", "doc", "5")
                .source(XContentType.JSON,"field", "baz"));
        BulkResponse bulkResponse = restHighLevelClient.bulk(request);
        for(BulkItemResponse bulkItemResponse : bulkResponse){
            DocWriteResponse itemResponse = bulkItemResponse.getResponse();
            if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                    || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                // 处理 创建索引操作的响应
                IndexResponse indexResponse = (IndexResponse) itemResponse;
                System.out.println("index操作后处理："+indexResponse);

            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                // 处理 更新索引操作的响应
                UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                System.out.println("update操作后处理："+updateResponse);
            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                // 处理 删除索引操作的响应
                DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
                System.out.println("delete操作后处理："+deleteResponse);
            }
        }
    }

}
