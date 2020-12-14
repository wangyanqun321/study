package com.wyq.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author 王艳群
 * @description TestController
 * @date 2020/7/12
 */
@RestController
@RequestMapping("/test")
public class TestController {

    //private TestService testService;

    /*@Autowired
    @Qualifier("cat")
    private Cat cat;*/

    /*public TestController(TestService testService) {
        this.testService = testService;
    }*/

    @PostMapping("/upload")
    public String testUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        String resource = "E:\\project\\idea\\study\\springboot\\src\\main\\resources";
        System.out.println(File.separator);
        file.transferTo(new File(resource + File.separator + file.getOriginalFilename()));
        return "success";
    }

    @GetMapping("/event")
    public String testPublishEvent() {
        //System.out.println(cat);
        // testService.publisherEvent();
        return "OK";
    }

}
