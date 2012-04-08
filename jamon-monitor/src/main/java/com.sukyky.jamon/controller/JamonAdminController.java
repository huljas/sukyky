package com.sukyky.jamon.controller;

import com.jamonapi.MonitorFactory;
import com.sukyky.jamon.aspect.Jamon;
import com.sukyky.jamon.util.ReportUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huljas
 */

@Controller
@Jamon("JamonAdmin")
public class JamonAdminController {

    @RequestMapping("/jamon/admin")
    public void admin(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        ReportUtils.renderAdminPage("/jamon", response.getOutputStream());
        response.getOutputStream().flush();
    }

    @RequestMapping("/jamon/toggle")
    public String toggle() {
        MonitorFactory.setEnabled(!MonitorFactory.isEnabled());
        return "redirect:/jamon/admin";
    }

    @RequestMapping("/jamon/reset")
    public String reset() {
        MonitorFactory.reset();
        return "redirect:/jamon/admin";
    }


}
