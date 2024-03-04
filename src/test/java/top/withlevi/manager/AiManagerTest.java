package top.withlevi.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiManagerTest {


    @Resource
    private AiManager aiManager;


    @Test
    void doChat() {
        String answer = aiManager.doChat(1761663810785464321L,"分析需求:\n" +
                "\n" +
                "分析网站用户的增长情况\n" +
                "\n" +
                "原始数据:\n" +
                "\n" +
                "日期, 用户数\n" +
                "\n" +
                "1号,10\n" +
                "\n" +
                "2号, 20\n" +
                "\n" +
                "3号, 30");
        System.out.println(answer);

    }
}