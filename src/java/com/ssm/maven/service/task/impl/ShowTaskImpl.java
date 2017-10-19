package com.ssm.maven.service.task.impl;

import com.ssm.maven.service.task.ShowTask;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Song Yimin
 * @Description:
 * @Date: 2017/10/19 23:10
 */
@Component
public class ShowTaskImpl implements ShowTask {
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron ="0/1 * *  * * ? ")
    @Override
    public void showA() {
        System.out.println(sdf.format(new Date())+"*********A任务每1秒执行一次进入测试");
    }

    @Scheduled(cron ="0/5 * *  * * ? ")
    @Override
    public void showB() {
        System.out.println(sdf.format(new Date())+"*********b任务每5秒执行一次进入测试");
    }
}
