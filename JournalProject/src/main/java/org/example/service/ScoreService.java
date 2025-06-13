package org.example.service;

import org.example.model.Score;
import org.example.util.JsonSerialization;
import org.example.util.Validator;

import java.io.FileOutputStream;
import java.util.List;

public class ScoreService {

    private List<Score> scores;

    public void addScore(Score score) throws Exception {
        Validator.validateScore(score, scores);
        scores.add(score);
        JsonSerialization.serialize(scores, new FileOutputStream("src/main/resources/data/scores.json"));
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}