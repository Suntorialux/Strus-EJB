package com.epam.by.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MDBProject
 */
@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/MyQueue") })
public class MDBProject implements MessageListener {

	/**
	 * Default constructor.
	 */
	public MDBProject() {

	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {

		try {
			TextMessage msg = (TextMessage) message;
			System.out.println("Message is : " + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
