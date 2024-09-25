package calendar.repository;

import calendar.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private Map<Long, Member> memberStore = new HashMap<>();


    @Override
    public void save(Member member) {
        memberStore.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return memberStore.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    @Override
    public void deleteById(Long id) {
        memberStore.remove(id);
    }
}
