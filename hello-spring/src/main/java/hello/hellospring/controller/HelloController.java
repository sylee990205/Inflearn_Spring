package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") /* get post 할 때 get */
    public String hello(Model model) {
        model.addAttribute("data", "spring~!!");
        return "hello"; // template에 있는 hello 라는 모델을 실행시키라고 전달한것
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTML에 나오는 Body가 아님, Http 통신 프로토콜의 Body 부분에 데이터를 직접 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    // 데이터를 내라고 할 때
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
