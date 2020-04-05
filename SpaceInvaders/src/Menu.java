import java.awt.*;

public class Menu {
    public static int StartMenu(){
        StdDraw.clear(Color.black);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 1.25, "ressources/Pictures/intro.png",
                Invaders.WIDTH, 720 * Invaders.WIDTH / 1280);

        // New Game
        if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 25 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 + 25){

            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 250, 25); // New Game
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, "New Game");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 252, 27); // New Game

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 250, 25); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 250, 25); // Highscores
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 250, 25); // Quit
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, "Options");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, "Highscores");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, "Quit");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 252, 27); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 252, 27); // Highscores
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 252, 27); // Quit

            if (StdDraw.isMousePressed())
                return 0;
        }

        // Options, credits...
        else if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
        && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 100 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 50){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 250, 25); // Options
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, "Options");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 252, 27); // Options

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 250, 25); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 250, 25); // Highscores
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 250, 25); // Quit
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, "New Game");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, "Highscores");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, "Quit");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 252, 27); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 252, 27); // Highscores
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 252, 27); // Quit

            if (StdDraw.isMousePressed())
                return 1;
        }

        // Highscores
        else if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
        && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 175 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 125){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 250, 25); // Highscores
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, "Highscores");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 252, 27); // Highscores

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 250, 25); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 250, 25); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 250, 25); // Quit
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, "New Game");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, "Options");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, "Quit");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 252, 27); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 252, 27); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 252, 27); // Quit

            if (StdDraw.isMousePressed())
                return 2;
        }

        // Quit
        else if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
        && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 325 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 275){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 250, 25); // Quit
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, "Quit");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 252, 27); // Quit

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 250, 25); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 250, 25); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 250, 25); // Highscores
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, "New Game");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, "Options");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, "Highscores");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 252, 27); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 252, 27); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 252, 27); // Highscores

            if (StdDraw.isMousePressed())
                return 3;
        }
        else{
            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 250, 25); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 250, 25); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 250, 25); // Highscores
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 250, 25); // Quit
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, "New Game");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, "Options");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, "Highscores");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, "Quit");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 252, 27); // New Game
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 75, 252, 27); // Options
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 150, 252, 27); // Highscores
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 300, 252, 27); // Quit
        }

        StdDraw.show();

        return -1;
    }

    // Controls = 0 / About = 1 / Menu = 2 / Not chosen yet = -1
    public static int OptionMenu(){
        StdDraw.clear(Color.black);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 1.25, "ressources/Pictures/intro.png",
                Invaders.WIDTH, 720 * Invaders.WIDTH / 1280);

        StdDraw.picture(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 3.5, "ressources/Pictures/hello.png");

        StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));

        // Controls
        if (StdDraw.mouseX() >= Invaders.WIDTH / 4 - 126 && StdDraw.mouseX() <= Invaders.WIDTH / 4 + 126
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 25 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 + 25){

            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // Controls
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "Controls");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // Controls

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // About
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 250, 25); // Menu
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "About");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, "Menu");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // About
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 252, 27); // Menu

            if (StdDraw.isMousePressed())
                return 0;
        }

        // About
        else if (StdDraw.mouseX() >= 3 * Invaders.WIDTH / 4 - 126 && StdDraw.mouseX() <= 3 * Invaders.WIDTH / 4 + 126
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 25 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 + 25){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(3 * Invaders.WIDTH / 2, Invaders.HEIGHT / 2, 124, 25); // About
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "About");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // About

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // Controls
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 250, 25); // Menu
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "Controls");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, "Menu");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // Controls
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 252, 27); // Menu

            if (StdDraw.isMousePressed())
                return 1;
        }

        // Menu
        else if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 250 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 200){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 250, 25); // Menu
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, "Menu");
            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 252, 27); // Menu

            StdDraw.setPenColor(255, 200, 0);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // Controls
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // About
            StdDraw.text(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "Controls");
            StdDraw.text(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "About");
            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // Controls
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // About

            if (StdDraw.isMousePressed())
                return 2;
        }
        else{
            StdDraw.setPenColor(255, 200, 0);
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // Controls
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 124, 25); // About
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 250, 25); // Menu
            StdDraw.text(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "Controls");
            StdDraw.text(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, "About");
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, "Menu");
            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 252, 27); // Menu
            StdDraw.rectangle(Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // Controls
            StdDraw.rectangle(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2, 126, 27); // About
        }

        StdDraw.show();

        return -1;
    }

    public static int OptionControls(){
        StdDraw.clear(Color.black);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 1.25, "ressources/Pictures/intro.png",
                Invaders.WIDTH, 720 * Invaders.WIDTH / 1280);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 3.1, "ressources/Pictures/optionControls.png",
                550, 413);

        if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 400 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 350){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 250, 25); // Back
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, "Back");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 252, 27); // Back

            if (StdDraw.isMousePressed())
                return 0;
        }
        else{
            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 250, 25); // Back
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, "Back");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 252, 27); // Back
        }

        StdDraw.show();

        return -1;
    }

    public static int OptionAbout(){
        StdDraw.clear(Color.black);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 1.25, "ressources/Pictures/intro.png",
                Invaders.WIDTH, 720 * Invaders.WIDTH / 1280);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 3.1, "ressources/Pictures/optionAbout.png",
                Invaders.WIDTH, 384);

        if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 400 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 350){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 250, 25); // Back
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, "Back");

            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 252, 27); // Back

            if (StdDraw.isMousePressed())
                return 0;
        }
        else{
            StdDraw.setPenColor(255, 200, 0);
            StdDraw.setPenRadius(0.005);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 250, 25); // Back
            StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, "Back");

            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 375, 252, 27); // Back
        }

        StdDraw.show();

        return -1;
    }
}
