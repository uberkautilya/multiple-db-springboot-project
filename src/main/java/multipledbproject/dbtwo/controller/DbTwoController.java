package multipledbproject.dbtwo.controller;

import multipledbproject.dbtwo.entity.Content;
import multipledbproject.dbtwo.service.DbTwoService;
import multipledbproject.models.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("users")
public class DbTwoController {
    private DbTwoService dbTwoService;

    @GetMapping
    public ResponseBody findAllContent() {
        List<Content> contentList = dbTwoService.findAll();
        Response response = new Response();
        response.setContentList(contentList);
        return response;
    }
}
