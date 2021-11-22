package com.revature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JSHelper {
    public static ArrayList<String> addToTableJS(Request req, String tableId, boolean isSelectable, boolean hasEmpId) {
        ArrayList<String> js = new ArrayList<>();
        js.add("var table = document.getElementById('" + tableId + "');");
        js.add("var row = table.insertRow(1);");
        js.add("var cell1 = row.insertCell(0);");
        js.add("var cell2 = row.insertCell(1); ");
        js.add("var cell3 = row.insertCell(2);");
        js.add("var cell4 = row.insertCell(3);");
        js.add("var cell5 = row.insertCell(4);");
        js.add("var cell6 = row.insertCell(5);");
        js.add("cell1.innerHTML = '" + req.getReqId() + "';");
        js.add("cell2.innerHTML = '" + req.getTitle() + "';");
        js.add("cell3.innerHTML = '" + req.getDescription() + "';");
        js.add("cell4.innerHTML = '" + req.getAmount() + "';");
        js.add("cell5.innerHTML = '" + pendingText(req.isPending()) + "';");
        js.add("cell6.innerHTML = '" + dateText(req.getDateSubmitted()) + "';");
        if(hasEmpId){
            js.add("var cell7 = row.insertCell(6);");
            js.add("cell7.innerHTML = '" + req.getEmployee().getEmpId() + "';");
        }
        if(isSelectable){
            js.add("row.setAttribute('onclick', 'selectRow(this)')");
        }
        return js;
    }

    public static String pendingText(boolean isPending) {
        if (isPending)
            return "Pending";
        else
            return "Fulfilled";
    }

    public static String dateText(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(date);
    }

    public static String updateNavUsernameJS(String name){
        System.out.println("Name passed in: " + name);
        return "<script>document.getElementById('navUsername').innerText = '" + name + "';</script>";
    }
}
