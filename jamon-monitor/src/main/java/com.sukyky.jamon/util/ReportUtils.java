package com.sukyky.jamon.util;

import com.jamonapi.MonitorFactory;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author huljas
 */
public class ReportUtils {

    /**
     * Writes Jamon report as a single html page with jquery dataTables plugin.
     */
    public static void renderAdminPage(String baseUrl, OutputStream out) {
        try {
            String report = MonitorFactory.getReport();
            report = report.replaceAll("(<table[^>]*>)", "$1<thead><tr>");
            report = report.replaceAll("(</th>)(\\s*<tr>)", "$1</tr></thead><tbody>$2");
            report = report.replaceAll("(</tr>)(\\s*</table>)", "$1</tbody>$2");
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang=\"en\">");
            writer.println("<head>");
            writer.println("  <meta charset=\"utf-8\">");
            writer.println("  <title>Jamon admin</title>");
            writer.println("  <link href=\"http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css\" rel=\"stylesheet\">");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div><a href=\"" + baseUrl + "/toggle\">" + (MonitorFactory.isEnabled() ? "Disable": "Enable") + "</a> <a href=\"" + baseUrl + "/reset\">Reset</a></div>");
            writer.println("<h1>Jamon admin</h1>");
            writer.println(report);
            writer.println("<script src=\"http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.2.min.js\"></script>");
            writer.println("<script src=\"http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js\"></script>");
            writer.println("<script>$(function() {$(\"table\").dataTable();});</script>");
            writer.println("</body></html>");
            writer.flush();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Should never be thrown", e);
        }

    }
}
