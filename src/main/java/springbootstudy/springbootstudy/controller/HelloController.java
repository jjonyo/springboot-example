package springbootstudy.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("hello")
  public String getHello(Model model) {
    model.addAttribute("data", "Spring");

    return "hello";
  }

  @GetMapping("hello-mvc")
  @ResponseBody
  public String helloMvc(@RequestParam("name") String name) {
    return "hello";
  }
}
