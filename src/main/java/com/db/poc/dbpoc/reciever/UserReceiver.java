package com.db.poc.dbpoc.reciever;

import com.db.poc.dbpoc.domain.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class UserReceiver {

    @JmsListener(destination = "UserIngestionCompleted", containerFactory = "jmsFactory")
    public void receiveIngestionMessage(User user) {
        System.out.println("Received UserIngestionCompleted <" + user + ">");
    }

    @JmsListener(destination = "UserDeletionCompleted", containerFactory = "jmsFactory")
    public void receiveDeletionMessage(User user) {
        System.out.println("Received UserDeletionCompleted <" + user + ">");
    }

}
