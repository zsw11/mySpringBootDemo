package com.zsw.componentConfig;

import com.zsw.service.MailSendLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *DirectExchange
 * 直连型交换机，根据消息携带的路由键，将消息转发给对应的队列
 *
 * FanoutExchange
 * 扇形交换机，接收到消息后会将消息转发到所有队列
 *
 * TopicExchange
 * 主题交换机，根据消息携带的路由键和交换机与队列绑定键的规则，将消息转发给对应的队列   这里没有配置交换机类型
 */
@Configuration
public class RabbitConfig {
    public final static Logger logger = LoggerFactory.getLogger(RabbitConfig.class);
    @Autowired
    CachingConnectionFactory cachingConnectionFactory;
    @Autowired
    MailSendLogService mailSendLogService;

    /*注入rabbitTemplate*/
    @Bean
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgId = data.getId();
            if (ack) {
                logger.info(msgId + ":消息发送成功");
//                mailSendLogService.updateMailSendLogStatus(msgId, 1);//修改数据库中的记录，消息投递成功
            } else {
                logger.info(msgId + ":消息发送失败");
            }
        });
        rabbitTemplate.setReturnCallback((msg, repCode, repText, exchange, routingkey) -> {
            logger.info("消息发送失败");
        });
        return rabbitTemplate;
    }
//   创建队列
//    @Bean
//    Queue mailQueue() {
//        return new Queue(MailConstants.MAIL_QUEUE_NAME, true);
//    }
//
//    @Bean
//    DirectExchange mailExchange() {
//        return new DirectExchange(MailConstants.MAIL_EXCHANGE_NAME, true, false);
//    }
//
//    @Bean
//    Binding mailBinding() {
//        return BindingBuilder.bind(mailQueue()).to(mailExchange()).with(MailConstants.MAIL_ROUTING_KEY_NAME);
//    }

}
