package com.example.tdd_test.highscore;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/***
 * HighScoreService의 stub 클래스 구현을 이용한다는건 Game 클래스가 매번 같은 리스트를 반환한다는 의미.
 * stub 클래스 구현이 만능이 아님(이유는 아래)
 * 이 서비스가 리스트를 만드는데 한번만 호출되는지 Game 인스턴스가 다섯 명 각각 플레이어마다 서비스를 호출하면서 비효율적 동작을 하는지, 또는 전혀 호출되지 않고 Game 인스턴스가 안전하게 캐시된 값을 이용하는지 등이다.
 * -> Mock 객체를 이용한다.
 * -> 전달된 매개변수에 상관없이 다른 메서드 호출에 다른 응답을 할 수 있고 실제 예상한 대로 호출이 이루어지는지 판별하려고 각 호출을 기록할 수 있다.
 */
class GameTestWithStub {
    private static class StubHighScoreService implements HighScoreService {
        @Override
        public List<String> getTopFivePlayers(){
            return Arrays.asList(
                    "Alice",
                    "Bob",
                    "Charlie",
                    "Dave",
                    "Elizabeth"
            );
        }

        @Override
        public boolean saveHighScore(int score, String playerName) {
            throw new UnsupportedOperationException(
                    "saveHighScore noe implemented for this test"
            );
        }
    }

    @Test
    public void highScoreDisplay() {
        final String expectedPlayerList =
                "1. Alice\n" +
                "2. Bob\n" +
                "3. Charlie\n" +
                "4. Dave\n" +
                "5. Elizabeth\n";

        final HighScoreService stubbedHighScoreService = new StubHighScoreService();
        final Game gameUnderTest = new Game(stubbedHighScoreService);

        assertEquals(expectedPlayerList, gameUnderTest.displayHighScore());
    }
}