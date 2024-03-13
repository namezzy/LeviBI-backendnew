package top.withlevi.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created on 2024/3/13 9:59
 * 队列测试
 *
 * @author Levi
 */

@RestController
@RequestMapping("/queue")
@Slf4j
public class QueueController {

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @GetMapping("/add")
    // 接收一个参数name,然后将任务添加到线程池中
    public void add(String name) {
        // 打印CompletableFuture 运行一个异步任务
        CompletableFuture.runAsync( () -> {
            // 打印一条日志信息，包括任务名称和执行线程的名称
            log.info("任务执行中: "+name+", 执行人: "+ Thread.currentThread().getName());
            try {
                // 让线程休眠10分钟， 模型长时间运行的程序
                Thread.sleep(600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 异步任务在threadPooExecutor中执行
        }, threadPoolExecutor);
    }

    @GetMapping("/get")
    // 该方法返回线程池的状态信息
    public String get() {
        // 创建一个HashMap存储线程池的状态信息
        Map<String, Object> map = new HashMap<>();
        // 获取线程池的队列长度
        int size = threadPoolExecutor.getQueue().size();
        // 将队列长度放入map中
        map.put("队列长度: ", size);
        // 获取线程池已接收的任务总数
        long taskCount = threadPoolExecutor.getTaskCount();
        // 将任务总数放入map中
        map.put("任务总数",taskCount);
        // 获取线程池已完成的任务数
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        // 将已完成的任务数放入map中
        map.put("已完成任务数",completedTaskCount);
        // 获取线程池中正在执行任务的线程数
        int activeCount = threadPoolExecutor.getActiveCount();
        // 将正在工作的线程数放入map中
        map.put("正在工作的线程数",activeCount);
        // 将map转化为JSON字符串并返回
        return JSONUtil.toJsonStr(map);

    }

}
