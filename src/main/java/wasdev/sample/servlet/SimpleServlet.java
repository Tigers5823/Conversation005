package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;


/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Hello World!");

        ConversationService service = new ConversationService("2016-09-20");
        service.setUsernameAndPassword("f45c965e-919d-4f8a-a9e9-54a62512837f", "dVg7kHTD4SsH");

        MessageRequest newMessage = new MessageRequest.Builder()
        .inputText("Turn on the lights")
        // Replace with the context obtained from the initial request
        //.context(...)
        .build();

		String workspaceId = "ebd46f71-488a-411a-a302-1ba865db9e61";

		MessageResponse response1 = service
 		 .message(workspaceId, newMessage)
 		 .execute();

		System.out.println(response1);
    }
}