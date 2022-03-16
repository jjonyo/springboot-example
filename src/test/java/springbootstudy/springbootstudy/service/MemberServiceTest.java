package springbootstudy.springbootstudy.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springbootstudy.springbootstudy.domain.Member;
import springbootstudy.springbootstudy.repository.InMemoryMemberRepository;
import springbootstudy.springbootstudy.repository.MemberRepository;

class MemberServiceTest {

  MemberRepository memberRepository;
  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    memberRepository = new InMemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach() {
    memberRepository.clear();
  }

  @Test
  void join() {
    //given
    Member member = new Member();
    member.setName("spring");

    //when
    Long result = memberService.join(member);

    //then
    assertThat(member.getId()).isEqualTo(result);
  }

  @Test
  void checkDuplicateName() {
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member2));
    assertThat(e.getMessage()).isEqualTo(memberService.NOT_ALLOW_DUPLICATE_NAME);
  }

  @Test
  void findMembers() {
    Member member1 = new Member();
    member1.setName("member1");

    Member member2 = new Member();
    member2.setName("member2");

    memberRepository.save(member1);
    memberRepository.save(member2);

    List<Member> result = memberRepository.findAll();

    assertThat(result.size()).isEqualTo(2);
    assertThat(result.get(0).getId()).isEqualTo(member1.getId());
  }

  @Test
  void findOne() {
  }
}