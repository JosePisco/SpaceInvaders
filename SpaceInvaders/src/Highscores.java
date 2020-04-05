import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Highscores {

    public static List<Integer> GetHighscores(){
        List<Integer> highscores = new ArrayList<>();
        Scanner file;
        try {
            file = new Scanner(new File("ressources/highscores"));
            while (file.hasNextInt()){
                highscores.add(file.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = highscores.size();
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(highscores.get(j - 1) < highscores.get(j)){
                    int temp = highscores.get(j - 1);
                    highscores.set(j - 1, highscores.get(j));
                    highscores.set(j, temp);
                }

            }
        }

        return highscores;
    }

    public static void AddScore(int score){
        List<Integer> scores = GetHighscores();
        try {
            FileWriter writer = new FileWriter("ressources/highscores");
            for (Integer i : scores) {
                writer.write(i.toString() + "\n");
            }
            writer.write(score + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int HighscoresMenu(int score){
        StdDraw.clear(Color.black);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 1.25, "ressources/Pictures/intro.png",
                Invaders.WIDTH, 720 * Invaders.WIDTH / 1280);

        StdDraw.picture(Invaders.WIDTH / 2, Invaders.HEIGHT / 48, "ressources/Pictures/soskilled.png");

        List<Integer> highscores = GetHighscores();

        StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 20));
        StdDraw.setPenColor(255, 200, 0);
        int space = 0;
        for (int i = 0; i < 10; i++){
            if (i < 5){
                if (highscores.get(i) == score){
                    StdDraw.setPenColor(0, 50, 186);
                    StdDraw.text(Invaders.WIDTH / 4, Invaders.HEIGHT / 2 + space, (i + 1) + "- " + highscores.get(i).toString());
                    StdDraw.setPenColor(255, 200, 0);
                }
                else
                    StdDraw.text(Invaders.WIDTH / 4, Invaders.HEIGHT / 2 + space, (i + 1) + "- " + highscores.get(i).toString());
            }

            else{
                if (i == 5)
                    space = 0;
                if (highscores.get(i) == score){
                    StdDraw.setPenColor(0, 50, 186);
                    StdDraw.text(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2 + space, (i + 1) + "- " + highscores.get(i).toString());
                    StdDraw.setPenColor(255, 200, 0);
                }
                else
                    StdDraw.text(3 * Invaders.WIDTH / 4, Invaders.HEIGHT / 2 + space, (i + 1) + "- " + highscores.get(i).toString());
            }
            space -= 40;
        }

        StdDraw.setFont(new Font("AAAAAA", Font.BOLD, 30));
        if (StdDraw.mouseX() >= Invaders.WIDTH / 2 - 255 && StdDraw.mouseX() <= Invaders.WIDTH / 2 + 255
                && StdDraw.mouseY() >= Invaders.HEIGHT / 2 - 250 && StdDraw.mouseY() <= Invaders.HEIGHT / 2 - 200){
            StdDraw.setPenColor(0, 50, 186);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 250, 25); // Quit
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, "Menu");
            StdDraw.setPenColor(0, 196, 255);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 252, 27); // Quit

            if (StdDraw.isMousePressed())
                return 0;
        }
        else{
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 250, 25); // Quit
            StdDraw.text(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, "Menu");
            StdDraw.setPenColor(255, 51, 51);
            StdDraw.rectangle(Invaders.WIDTH / 2, Invaders.HEIGHT / 2 - 225, 252, 27); // Quit
        }

        StdDraw.show();

        return -1;
    }
}
