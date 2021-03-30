# mySpringBootDemo
拆分模块，基于springboot开发的各种技术整合，
基于springboot数据整合技术。已经配置好了各种配置类可供参考。
优点：提供一个快速的spring项目搭建渠道
     开箱即用，很少的spring配置就可以运行一个spring项目
     提供了生产级别的服务监控方案
     内嵌tomcat可以快速的部署
     通用配置，不用xml

mybaits
自己分模块搭建springboot项目，供自己平时学习，整合一些技术
20200129 整和 @Async

20200119  整合elk，搭建实时日志平台。
          Elasticsearch是个开源分布式搜索引擎，它的特点有：分布式，零配置，自动发现，索引自动分片，索引副本机制，restful风格接口，多数据源，自动搜索负载等。
          Logstash是一个完全开源的工具，他可以对你的日志进行收集、过滤，并将其存储供以后使用（如，搜索）。
          Kibana 也是一个开源和免费的工具，它Kibana可以为 Logstash 和 ElasticSearch 提供的日志分析友好的 Web 界面，可以帮助您汇总、分析和搜索重要数据日志。

20200119 Spring Boot优先于配置的惯例，旨在让您尽快启动和运行。在一般情况下，我们不需要做太多的配置就能够让spring boot正常运行。
         在一些特殊的情况下，我们需要做修改一些配置，或者需要有自己的配置属性。

20200320 springboot 打包会生成两个jar包， 一个是user-web-1.0-SNAPSHOT-main.jar 可执行的jar。
         一个是 user-web-1.0-SNAPSHOT.jar 可给别的项目依赖的jar
         修改： jar打包方式，一种还是maven 打包，需要指定主类，
               一种是 springboot 打包不用指定主类。本项目由于我的springboot版本低了，所以默认的打包版本是jdk1.6
               今天进行了修改吧。         
