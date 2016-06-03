package com.epam.by.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendController
 */
public class SendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		final String QUEUE_LOOKUP = "queue/MyQueue";
		final String CONNECTION_FACTORY = "ConnectionFactory";

		PrintWriter out = response.getWriter();
		try {
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.PROVIDER_URL, "localhost:1099");

			Context context = new InitialContext(properties);

			QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup(CONNECTION_FACTORY);
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) context.lookup(QUEUE_LOOKUP);
			QueueSender sender = session.createSender(queue);

			TextMessage message = session.createTextMessage();
			message.setText("Hello EJB MDB Queue!!!");
			sender.send(message);
			out.println("1. Sent TextMessage to the Queue");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
