package com.ironhack.modeling.respositoryTest;

import com.ironhack.modeling.model.Member;
import com.ironhack.modeling.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    Member member;

    @BeforeEach
    void setUp() {
        member = new Member(1244,"Yoland");
        memberRepository.save(member);

    }
    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }


    @Test
    public void findAll_membersPresent_memberList() {
        Member newMember = new Member(5678, "Yuri");
        memberRepository.save(newMember);
        List<Member> memberList = memberRepository.findAll();
        assertEquals(2, memberList.size());
    }

    @Test
    public void deleteById_validId_memberDeleted() {
        memberRepository.deleteById(1244);
        Optional<Member> foundMember = memberRepository.findById(1244);
        assertTrue(foundMember.isEmpty());
    }


    @Test
    public void findById_invalidId_memberNotPresent() {
        Optional<Member> chapterOptional = memberRepository.findById(453);
        assertTrue(chapterOptional.isEmpty());
    }

}
