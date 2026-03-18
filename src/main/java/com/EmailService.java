package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCustomerMail(Customer c){

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo("YOUR_RECEIVING_MAIL@gmail.com");
        msg.setSubject("New Loan Customer Received");

        msg.setText(
                "New Customer Details:\n\n" +
                "Name: " + c.getName() + "\n" +
                "Mobile: " + c.getMobile() + "\n" +
                "Email: " + c.getEmail() + "\n" +
                "Loan Type: " + c.getLoanType() + "\n" +
                "Message: " + c.getMessage()
        );

        mailSender.send(msg);
    }
}