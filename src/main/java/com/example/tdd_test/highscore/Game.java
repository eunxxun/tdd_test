package com.example.tdd_test.highscore;

import java.util.List;

public class Game {
    /***
     * Game Class는 HighScoreService 인터페이스에 의존적이다. 어디서 어떻게 높은 점수를 얻는지 신경쓰지 않음.
     */
    private final HighScoreService highScoreService;

    public Game(HighScoreService highScoreService) {
        this.highScoreService = highScoreService;
    }

    public String displayHighScore() {
        final List<String> topFivePlayers = highScoreService.getTopFivePlayers();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < topFivePlayers.size(); i++) {
            String player = topFivePlayers.get(i);
            sb.append(String.format("%d. %s%n", i+1, player));
        }

        return sb.toString();
    }
}
