package com.example.staff.service.Impl;

import com.example.staff.entity.Employee;
import com.example.staff.service.EmployeeService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class MailServiceImpl implements  Job {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    EmployeeService employeeService;


    private void sendEmployeeList() {

        List<Employee> employeeList = employeeService.findAll();


        // Cấu hình thông tin email
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        String username = "hotro.hcmute@gmail.com";
        String password = "xskjqocjnyctaixj";



        // Tạo session
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);
            // Thiết lập người gửi
            message.setFrom(new InternetAddress(username));
            // Thiết lập người nhận
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
            // Thiết lập chủ đề
            message.setSubject("Danh sách nhân viên hàng ngày");
            // Thiết lập nội dung email
            message.setText(employeeList.toString());

            // Gửi email
            Transport.send(message);

            System.out.println("Email đã được gửi thành công!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        sendEmployeeList();
    }
}
