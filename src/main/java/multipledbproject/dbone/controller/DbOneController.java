package multipledbproject.dbone.controller;

import multipledbproject.dbone.entity.User;
import multipledbproject.dbone.service.DbOneService;
import multipledbproject.models.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("users")
public class DbOneController {
    private DbOneService dbOneService;

    @GetMapping
    public ResponseBody findAllUsers() {
        List<User> userList = dbOneService.findAll();
        Response response = new Response();
        response.setUserList(userList);
        return response;
    }
}
