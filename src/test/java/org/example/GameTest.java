package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    Game game = new Game();
    Player giocatore = new Player("Sara");

    @BeforeEach
    void initAmbiente(){
        game.setPlayers(new ArrayList<>());
        game.getPlayers().add(giocatore);
    }


    @Test
    void roll_numeroBirilliCaduti_aumentoScoreTotale() {
        game.roll(giocatore, 5);
        assertThat(game.scoreTotale).isEqualTo(5);
    }

    @Test
    void rollx2_numeroBirilliperScorePerGiocatore() {
        game.roll(giocatore, 5);
        game.roll(giocatore, 2);
        assertThat(game.scoreTotale).isEqualTo(7);
    }

    @Test
    void rollx2_buttatiGiu10Birilli_Spare() {
        game.roll(giocatore, 5);
        game.roll(giocatore, 5);
        assertThat(giocatore.spare).isEqualTo(true);
    }

    @Test
    void rollx1_buttatiGiu10Birilli_Strike() {
        game.roll(giocatore, 10);
        assertThat(giocatore.strike).isEqualTo(true);
    }

    @Test
    void rollx1_dopoSpare_BonusValorePrimoTiro() {
        giocatore.setScore_game(10);
        giocatore.setSpare(true);
        game.roll(giocatore, 5);
        assertThat(giocatore.score_game).isEqualTo(20);
    }

    @Test
    void rollx2_dopoStrike_BonusValorePrimiDueTiri() {
        giocatore.setScore_game(10);
        giocatore.setStrike(true);
        game.roll(giocatore, 2);
        game.roll(giocatore, 0);
        assertThat(giocatore.score_game).isEqualTo(14);
    }

    @Test
    void decimoFrame_dopoStrike_BonusPalla() {
        giocatore.setScore_game(10);
        giocatore.setStrike(true);
        game.roll(giocatore, 2);
        game.roll(giocatore, 0);
        assertThat(giocatore.score_game).isEqualTo(14);
    }
}