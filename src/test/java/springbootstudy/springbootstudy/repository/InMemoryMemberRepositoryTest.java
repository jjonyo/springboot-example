package springbootstudy.springbootstudy.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springbootstudy.springbootstudy.domain.Member;

public class InMemoryMemberRepositoryTest {

  InMemoryMemberRepository inMemoryMemberRepository = new InMemoryMemberRepository();

  @AfterEach
  public void afterEach() {
    inMemoryMemberRepository.clear();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("박종혁");

    inMemoryMemberRepository.save(member);

    Member result = inMemoryMemberRepository.findById(member.getId()).get();

    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member = new Member();
    member.setName("박종혁");

    inMemoryMemberRepository.save(member);

    Member result = inMemoryMemberRepository.findByName("박종혁").get();
    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("박종혁");
    inMemoryMemberRepository.save(member1);

    Member member2 = new Member();
    member2.setName("박종혁2");
    inMemoryMemberRepository.save(member2);

    List<Member> result = inMemoryMemberRepository.findAll();
    assertThat(result.size()).isEqualTo(2);
  }
}
