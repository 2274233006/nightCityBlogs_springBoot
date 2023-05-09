package com.nightCityBlogs.controller.article;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@CrossOrigin(origins = "http://127.0.0.1:5173", allowCredentials = "true")
public class textController {
}
