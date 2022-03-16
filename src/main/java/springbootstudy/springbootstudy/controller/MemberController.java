package springbootstudy.springbootstudy.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootstudy.springbootstudy.domain.Member;
import springbootstudy.springbootstudy.repository.InMemoryMemberRepository;
import springbootstudy.springbootstudy.repository.MemberRepository;
import springbootstudy.springbootstudy.service.MemberService;

@Controller
public class MemberController {

  private final MemberService memberService;

  MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping("/member")
  public Long saveMember(String name) {
    Member member = new Member();
    member.setName(name);

    return this.memberService.join(member);
  }

  @GetMapping("/members")
  public String members(Model model) {
    List<Member> members = memberService.findMembers();
    System.out.println(members);
    model.addAttribute("members", members);

    return "members";
  }

  @GetMapping("/members/new")
  public String memberForm() {
    return "createMemberForm";
  }

  @PostMapping("/members/new")
  public String createMember(@RequestBody() String name) {
    Member member = new Member();
    member.setName(name);

    memberService.join(member);

    return "home";
  }

  @GetMapping("members/{name}")
  @ResponseBody
  public Optional<Member> getOneMember(@PathVariable("name") String name) {
    Optional<Member> result = memberService.findOneByName(name);
    System.out.println(result.get());
    return result;
  }
}
