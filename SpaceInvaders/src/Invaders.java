public class Invaders {
    public static float WIDTH = 550;
    public static float HEIGHT = 750;

    public static void main(String[] args){
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(-50, HEIGHT);

        // Menu : 0 = New Game / 1 = Options, credits... / 2 = Highscores / 3 = Quit / -1 = Not chosen yet
        int menu = -1;
        while (menu != 3){
            menu = Menu.StartMenu();

            GameHandler gameHandler = new GameHandler(GameHandler.Background.SPACE);
            BonusHandler bonusHandler = new BonusHandler(5000);
            EnemyHandler enemyHandler = new EnemyHandler(0.5);
            Player player = new Player(0, 256, 27, 100, 3.5, 7.25, 2.10, 0, 27, Player.Ship.SPACE);
            Weapon weapon = new Weapon(System.currentTimeMillis(), Weapon.Ammo.BASIC);

            switch (menu){
                case 0:
                    gameHandler.InitiateMusic();

                    while (player.life > 0.0){
                        gameHandler.Update(player, weapon, bonusHandler, enemyHandler);
                    }
                    gameHandler.Update(player, weapon, bonusHandler, enemyHandler);
                    gameHandler.StopAllMusic();
                    Highscores.AddScore(player.score);

                    int game = -1;
                    while (game == -1){
                        game = Highscores.HighscoresMenu(player.score);
                    }
                    break;
                case 1:
                    int option = -1;
                    while (option != 2){
                        option = Menu.OptionMenu();

                        switch (option){
                            case 0:
                                int option0 = -1;
                                while (option0 == -1){
                                    option0 = Menu.OptionControls();
                                }
                                break;
                            case 1:
                                int option1 = -1;
                                while (option1 == -1)
                                    option1 = Menu.OptionAbout();
                                break;
                            default:
                                break;
                        }
                    }

                    break;
                case 2:
                    int scores = -1;
                    while (scores == -1)
                        scores = Highscores.HighscoresMenu(player.score);
                    break;
                default:
                    break;
            }
        }
    }
}
