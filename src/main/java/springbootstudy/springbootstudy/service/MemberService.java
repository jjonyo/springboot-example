package springbootstudy.springbootstudy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootstudy.springbootstudy.domain.Member;
import springbootstudy.springbootstudy.repository.MemberRepository;

public class MemberService {

  private final MemberRepository memberRepository;
  public final String NOT_ALLOW_DUPLICATE_NAME = "NOT_ALLOW_DUPLICATE_NAME";

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Long join(Member member) {
    validateDuplicateMemberName(member);
    memberRepository.save(member);
    return member.getId();
  }

  void validateDuplicateMemberName(Member member) {
    memberRepository.findByName(member.getName()).ifPresent(m -> {
      throw new IllegalStateException(NOT_ALLOW_DUPLICATE_NAME);
    });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long id) {
    return memberRepository.findById(id);
  }

  public Optional<Member> findOneByName(String name) {
    return memberRepository.findByName(name);
  }

}
