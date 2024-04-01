package com.example.staff;

import com.example.staff.service.Impl.EmployeeServiceImpl;
import com.example.staff.service.Impl.MailServiceImpl;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaffApplication {

    public static void main(String[] args) throws SchedulerException{
        SpringApplication.run(StaffApplication.class, args);

        // Khởi tạo Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // Khởi tạo công việc
        JobDetail job = JobBuilder.newJob(MailServiceImpl.class)
                .withIdentity("dailyEmployeeEmailJob", "group1")
                .build();

        // Khởi tạo Trigger để lên lịch gửi email mỗi ngày lúc 9 giờ sáng
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("dailyTrigger", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(9, 0))
                .build();

        // Đăng ký công việc với Scheduler
        scheduler.scheduleJob(job, trigger);

        // Khởi động Scheduler
        scheduler.start();
    }

}
