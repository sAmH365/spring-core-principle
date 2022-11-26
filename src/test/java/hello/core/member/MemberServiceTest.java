package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member memberA = new Member(1L, "memberA", Grade.BASIC);
        Member memberB = new Member(2L, "memberB", Grade.VIP);

        // when
        memberService.join(memberA);
        memberService.join(memberB);

        Member findMemberA = memberService.findMember(1L);
        Member findMemberB = memberService.findMember(2L);

        // then
        Assertions.assertThat(memberA).isEqualTo(findMemberA);

    }
}
