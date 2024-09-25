package calendar.repository;

import calendar.model.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long id);

    List<Member> findAll();

    void deleteById(Long id);
}
