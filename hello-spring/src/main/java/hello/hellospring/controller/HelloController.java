package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") /* get post 할 때 get */
    public String hello(Model model) {
        model.addAttribute("data", "spring~!!");
        return "hello"; // template에 있는 hello 라는 모델을 실행시키라고 전달한것
    }
}
