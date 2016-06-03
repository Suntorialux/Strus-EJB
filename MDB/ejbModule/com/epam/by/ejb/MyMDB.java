/**
 * 
 */
package com.epam.by.ejb;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Andrei Yahorau
 *
 */
public class MyMDB implements MessageDrivenBean, MessageListener {

	private static final long serialVersionUID = -720309812938270123L;

	private MessageDrivenContext ctx = null;
	private QueueConnection conn;
	private QueueSession session;

	public MyMDB() {

	}

	public void ejbCreate() {

		try {
			Context context = new InitialContext();
			QueueConnectionFactory qcf = (QueueConnectionFactory) context.lookup("java:comp/env/jms/QCF");
			conn = qcf.createQueueConnection();
			session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			conn.start();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onMessage(Message msg) {
		try {

			System.out.println("message received");

			System.out.println("-------------------The messege ->" + ((TextMessage) msg).getText());

		} catch (JMSException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void ejbRemove() throws EJBException {
		ctx = null;
		try {
			if (session != null) {
				session.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setMessageDrivenContext(MessageDrivenContext context) throws EJBException {
		this.ctx = context;
	}

}
