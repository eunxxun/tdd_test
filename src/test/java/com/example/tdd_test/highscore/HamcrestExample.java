package com.example.tdd_test.highscore;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/***
 * 가정을 명확하게 하고 테스트의 가독성을 개선하는데 Hamcrest 라이브러리라는 매쳐를 JUnit과 연계해서 사용할 수 있다.
 * Hamcrest 라이브러리를 이용하는 가정의 생성자는 DSL(Domain-Specific Language) 형식이다.
 */
public class HamcrestExample {

    @Test
    public void useHamcrest() {
        final Integer a = 400;
        final Integer b = 100;

        assertThat(a, is(notNullValue()));
        assertThat(a, is(equalTo(400)));
        assertThat(b-a, is(greaterThan(0)));
    }
}
