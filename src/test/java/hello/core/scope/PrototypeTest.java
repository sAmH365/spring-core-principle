package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeTest {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototype1");
        PrototypeBean prototype1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototype2");
        PrototypeBean prototype2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototype1 = " + prototype1);
        System.out.println("prototype2 = " + prototype2);

        assertThat(prototype1).isNotSameAs(prototype2);

        ac.close();
    }


    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("PrototypeBean.close");
        }
    }
}
