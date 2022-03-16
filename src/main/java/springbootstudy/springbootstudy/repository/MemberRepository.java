package springbootstudy.springbootstudy.repository;

import java.util.List;
import java.util.Optional;
import springbootstudy.springbootstudy.domain.Member;

public interface MemberRepository {

  Member save(Member save);

  Optional<Member> findById(Long id);

  Optional<Member> findByName(String name);

  List<Member> findAll();

  void clear();
}
