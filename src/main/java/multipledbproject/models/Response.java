package multipledbproject.models;

import multipledbproject.dbone.entity.User;
import multipledbproject.dbtwo.entity.Content;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;
import java.util.List;

public class Response implements ResponseBody {
    List<User> userList;
    List<Content> contentList;

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    @Override
    public String toString() {
        return "Response{" +
                "userList=" + userList +
                ", contentList=" + contentList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }
}
