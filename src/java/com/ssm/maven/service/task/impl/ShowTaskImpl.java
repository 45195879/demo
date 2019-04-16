package com.ssm.maven.service.task.impl;

import com.ssm.maven.dao.BookDao;
import com.ssm.maven.service.task.ShowTask;
import com.ssm.maven.util.ScheduleUtils;
import com.ssm.maven.util.ScheduleUtils.Job;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private BookDao dao;
    @Scheduled(cron = "0/10 * *  * * ? ")
    @Override
    public void showA() {

        System.out.println(sdf.format(new Date())+"*********A任务每1秒执行一次进入测试");
        Job job1 = new Job();
        job1.setClassName("com.ssm.maven.service.task.impl.ShowTaskImpl");
        job1.setCron("0/1 * * * * ?");
        job1.setJobName("定时器1");
        job1.setMethodName("showB");
        job1.setStatus(1);


        try {
            ScheduleUtils.add(job1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //测试
    /*@Scheduled(cron = "0/1 * *  * * ? ")*/
    @Override
    public void showB() {
        System.out.println(sdf.format(new Date()) + "*********b任务每5秒执行一次进入测试");
    }
}
