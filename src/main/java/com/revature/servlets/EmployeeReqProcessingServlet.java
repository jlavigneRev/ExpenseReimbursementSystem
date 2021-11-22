package com.revature.servlets;

import com.revature.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.Paths;
import java.util.Base64;

import static com.revature.ImgDataHelper.getByteArray;

@MultipartConfig
public class EmployeeReqProcessingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //retrieve input file
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">

        try {
            Part filePart = request.getPart("receipt"); // Retrieves <input type="file" name="receipt">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            InputStream fileContent = filePart.getInputStream();
            System.out.println(filePart.getContentType());
            byte[] byteArray = getByteArray(fileContent);

            //create new request obj
            HttpSession session = request.getSession();
            Request submittedRequest = new Request();
            submittedRequest.setTitle(request.getParameter("title"));
            submittedRequest.setDescription(request.getParameter("description"));
            submittedRequest.setAmount(Double.parseDouble(request.getParameter("amount")));
            submittedRequest.setPending(true);
            submittedRequest.setEmployee((Employee) session.getAttribute("currUser"));
            //add submitted request to db
            RequestService requestService = new RequestService();
            Serializable reqId = requestService.addRequest(submittedRequest);
            submittedRequest.setReqId((int) reqId);

            //add receipt to db
            ReceiptService receiptService = new ReceiptService();
            Receipt receipt = new Receipt();
            receipt.setReceiptImg(byteArray);
            receipt.setRequest(submittedRequest);
            receiptService.addReceipt(receipt);

            //send back to landing
            response.sendRedirect("employeeLanding");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
