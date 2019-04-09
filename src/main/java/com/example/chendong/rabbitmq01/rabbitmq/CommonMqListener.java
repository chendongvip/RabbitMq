package com.example.chendong.rabbitmq01.rabbitmq;

import com.example.chendong.rabbitmq01.entity.UserLog;
import com.example.chendong.rabbitmq01.mapper.UserLogMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CommonMqListener {

    private static final Logger logger = LoggerFactory.getLogger(CommonMqListener.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserLogMapper userLogMapper;

    /**
     * 监听消费用户日志
     * @param message
     */
    @RabbitListener(queues="${log.user.queue.name}",containerFactory = "singleListenerContainer")
    public void consumeUserLogQueue(@Payload byte[] message){
        try{
            UserLog userLog = objectMapper.readValue(message,UserLog.class);
            logger.info("监听消费用户日志 监听到消息：{}",userLog);

            userLogMapper.insertSelective(userLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
