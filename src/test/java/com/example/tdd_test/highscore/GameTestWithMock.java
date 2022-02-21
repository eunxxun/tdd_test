package com.example.tdd_test.highscore;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

/***
 * HighScoreService 인터페이스의 구현 없이도 최소한 주어진 테스트에서는 잘 작동.
 * 나중에 HighScoreService 구현이 변경되더라도 인터페이스 정의만 변경되지 않는다면 테스트에 영향을 미치지 않는다.
 * 즉, Game 클래스와 HighScoreService 인터페이스가 깔끔하게 분리되었다는 것이다.
 * Mockito의 Mock은 의존성 주입을 이용하지 않는 코드에서 작업할 때 매우 유용하다.
 * 단, Mockito 라이브러리는 final 키워드로 선언한 클래스는 만들 수 없다.
 * final 키워드로 선언한 클래스는 JVM에 저장되고 생성되는데, 이는 JVM이 보안을 위해 final 키워드로 선언한 클래스가 변경되지 않았는지 꼼꼼하게 확인하기 때문이다.
 */
public class GameTestWithMock {
    private final Game gameUnderTest;
    private final HighScoreService mockHighScoreService;

    public GameTestWithMock() {
        final List<String> firstHighScoreList = Arrays.asList(
                "Alice",
                "Bob",
                "Charlie",
                "Dave",
                "Elizabeth"
        );

        final List<String> secondHighScoreList = Arrays.asList(
                "Fred",
                "Georgia",
                "Helen",
                "Ian",
                "Jane"
        );

        //1. mock을 설정하는 부분
        this.mockHighScoreService = mock(HighScoreService.class);
        Mockito.when(mockHighScoreService.getTopFivePlayers())
                .thenReturn(firstHighScoreList)
                .thenReturn(secondHighScoreList);

        this.gameUnderTest = new Game(mockHighScoreService);
    }

    @Test
    public void highScoreDisplay() {
        final String firstExpectedPlayList =
                "1. Alice\n" +
                "2. Bob\n" +
                "3. Charlie\n" +
                "4. Dave\n" +
                "5. Elizabeth\n";

        final String secondExpectedPlayList =
                "1. Fred\n" +
                "2. Georgia\n" +
                "3. Helen\n" +
                "4. Ian\n" +
                "5. Jane\n";

        final String firstCall = gameUnderTest.displayHighScore();
        final String secondCall = gameUnderTest.displayHighScore();

        assertEquals(firstExpectedPlayList, firstCall);
        assertEquals(secondExpectedPlayList, secondCall);

        verify(mockHighScoreService, times(2)).getTopFivePlayers();
    }
}
