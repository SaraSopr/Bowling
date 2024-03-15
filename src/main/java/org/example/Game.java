package org.example;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Game {
    int frame = 1;
    int times = 0;

    int scoreTotale;
    int scoreTotaleFrame;

    List<Player> players;
    public void roll(Player giocatore, int birilliCaduti){
        giocatore.score_game += birilliCaduti;
        giocatore.score_frame += birilliCaduti;
        checkBonusPointStrike(giocatore);
        checkBonusPointSpare(birilliCaduti, giocatore);
        checkStrike(giocatore, birilliCaduti);
        checkSpare(giocatore);


        this.scoreTotale += birilliCaduti;
        times += 1;

    }

    private void checkBonusPointStrike(Player giocatore) {
        if(giocatore.strike){
            if(times == 1){
                giocatore.score_game += giocatore.score_frame;
                giocatore.strike = false;
            }
        }
    }

    private void checkBonusPointSpare(int birilliCaduti, Player giocatore) {
        if(giocatore.spare) {
            giocatore.score_game += birilliCaduti;
            giocatore.spare = false;
        }
    }

    private static void checkStrike(Player giocatore, int birilliCaduti) {
        if(birilliCaduti == 10)
            giocatore.strike = true;
    }

    private void checkSpare(Player giocatore) {
        if(times == 1){
            if (giocatore.score_frame == 10)
                giocatore.spare = true;
            times = 0;
        }
    }

    public int score(){
        return scoreTotale;
    }


}
