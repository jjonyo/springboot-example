package springbootstudy.springbootstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springbootstudy.springbootstudy.service.MemberService;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "home";
  }
}
