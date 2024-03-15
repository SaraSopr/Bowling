package org.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Player {

    String nome;
    int score_game;
    int score_frame;
    boolean spare;
    boolean strike;
    public Player(String nome) {
        this.nome = nome;
    }
}
