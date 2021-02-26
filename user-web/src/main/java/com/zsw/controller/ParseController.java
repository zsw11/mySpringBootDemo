package com.zsw.controller;

import com.alibaba.druid.util.StringUtils;
import com.zsw.config.HtmlParseUtil;
import com.zsw.respondVo.ParseDemo;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author zsw
 * @date 2021/2/25 16:48
 * @description :parse   从jsoup爬出来的数据 存到 ElasticSearch
 */
@RestController
public class ParseController {
    @Autowired
    private HtmlParseUtil htmlParseUtil;
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @GetMapping("/parse/{keyword}")
    public Boolean parse(@PathVariable("keyword") String keyword) throws IOException {
        if (!StringUtils.isEmpty(keyword)) {
            //爬去结果
            ArrayList<ParseDemo> parse = htmlParseUtil.parse(keyword);
            // 查询的结果到es中
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("2m");
            for (int i = 0; i < parse.size(); i++) {
                bulkRequest.add(
                        new IndexRequest("jd_goods","ParseDemo").source(parse.get(i), XContentType.JSON)
                );
            }
            BulkResponse bulk = restHighLevelClient.bulk(bulkRequest);
            return !bulk.hasFailures();
        }
        return true;
    }
}
