package com.example.tdd_test.highscore;

import java.util.List;

public interface HighScoreService {
    List<String> getTopFivePlayers();
    boolean saveHighScore(int score, String playerName);
}
