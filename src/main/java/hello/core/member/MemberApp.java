package hello.core.member;

import hello.core.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.BASIC);
        Member memberB = new Member(2L, "memberB", Grade.VIP);

        memberService.join(memberA);
        memberService.join(memberB);

        Member findA = memberService.findMember(1L);
        Member findB = memberService.findMember(2L);

        System.out.println("findA = " + findA.getName());
        System.out.println("findB = " + findB.getName());

        System.out.println("memberA == findA  : " + memberA.equals(findA));


    }
}
