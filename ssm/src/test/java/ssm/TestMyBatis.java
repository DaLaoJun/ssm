package ssm;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.pojo.UserT;
import com.cn.hnust.service.UserTService;

@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
  
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);  

    @Resource
    private UserTService userTService;  
  
  
    @Test  
    public void test1() {  
        UserT user = userTService.getUserById(1);  

        logger.info(JSON.toJSONString(user));  
    }  
}
