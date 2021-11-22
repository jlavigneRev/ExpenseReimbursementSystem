package com.revature.servlets;

import com.revature.Receipt;
import com.revature.ReceiptService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

public class ReceiptViewServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //get receipt img data
        ReceiptService receiptService = new ReceiptService();
        int reqId = Integer.parseInt(request.getParameter("receipt_req_id"));
        Receipt receipt = receiptService.getReceiptByReqId(reqId);
        byte[] imgData = receipt.getReceiptImg();

        String base64String = Base64.getEncoder().encodeToString(imgData);
        System.out.println("Base64 string:" + base64String);

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("");
        pw.println("<img id='ItemPreview' src=''>");
        pw.println("<script>");
        pw.println("document.getElementById('ItemPreview').src = 'data:image/jpeg;base64," + base64String + "'");
        pw.println("</script>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
