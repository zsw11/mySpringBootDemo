package es;

import com.zsw.ZSWApplication;
import org.elasticsearch.Build;
import org.elasticsearch.Version;
import org.elasticsearch.action.main.MainResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.cluster.ClusterName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zsw
 * @date 2021/2/24 16:51
 * @description :ElasticSearchTest   集群（cluster）info
 */
@SpringBootTest(classes = ZSWApplication.class)
@RunWith(SpringRunner.class)
public class EsInfoApi {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
   public void testCreateIndex() throws IOException {
        System.out.println("--------------------");
        MainResponse response = restHighLevelClient.info();
        ClusterName clusterName = response.getClusterName();
        String clusterUuid = response.getClusterUuid();
        String nodeName = response.getNodeName();
        Version version = response.getVersion();
        Build build = response.getBuild();
        System.out.println("ES info:"+response+",clusername："+clusterName+",clusterUuid:"+
                clusterUuid+",nodeName:"+nodeName+",version:"+version+",build:"+build);
    }

}
