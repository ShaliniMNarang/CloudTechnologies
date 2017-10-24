package com.themodestwhite.uploaddownloadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLRenderController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
    
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    
    @GetMapping("/filedetails")
    public String getFileDetails() {
        return "filedetails";
    }

//    @GetMapping("/")
//    public String getUploadPage() {
//        return "upload";
//    }
}