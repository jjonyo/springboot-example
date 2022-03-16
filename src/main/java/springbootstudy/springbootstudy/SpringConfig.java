package springbootstudy.springbootstudy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbootstudy.springbootstudy.repository.InMemoryMemberRepository;
import springbootstudy.springbootstudy.repository.MemberRepository;
import springbootstudy.springbootstudy.service.MemberService;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService getMemberService() {
    return new MemberService(getMemberRepository());
  }

  @Bean
  public MemberRepository getMemberRepository() {
    return new InMemoryMemberRepository();
  }
}
