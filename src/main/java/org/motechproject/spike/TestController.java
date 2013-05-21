package org.motechproject.spike;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/")
public class TestController {

    @ResponseBody
    @RequestMapping("/status")
    private String status() {
        return "Complimenti, si sta lavorando! " + new Date();
    }

    @ResponseBody
    @RequestMapping("/http")
    private String http() throws IOException {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod("http://www.google.com");
        final int responseCode = client.executeMethod(method);
        return "Status code: " + responseCode;
    }

    @ResponseBody
    @RequestMapping("/smpp")
    private String smpp() {
        return "SMPP";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new TestController().http());
    }
}
