package com.jiangle.bigevent.controller;

import com.jiangle.bigevent.pojo.Result;
import com.jiangle.bigevent.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final String TOKEN = "Authorization";
    @GetMapping("/list")
    public Result list(@RequestHeader(TOKEN) String token, HttpServletResponse response) {
        return Result.success("所有文章数据");
    }
}
