package org.academiadecodigo.koxtiposix.acdefender;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        Game g = new Game();

        ControlMenu controlMenu;
        controlMenu = new ControlMenu();
        controlMenu.setPlayer(g);
        controlMenu.init();

    }


    static class ControlMenu implements KeyboardHandler {

        private Game game;

        public void init() {

            Keyboard keyboard = new Keyboard(this);

            KeyboardEvent pressSpace = new KeyboardEvent();
            pressSpace.setKey(KeyboardEvent.KEY_ENTER);
            pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

            keyboard.addEventListener(pressSpace);
        }

        public void setPlayer(Game game) {
            this.game = game;
        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_ENTER:
                    try {
                        game.init();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {

        }

    }
}
