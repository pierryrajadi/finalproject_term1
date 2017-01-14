
import java.io.IOException;
import java.util.Scanner;
import model.Enemy;
import model.Hunter;
import util.FileUtil;
import util.Util;
//import org.fusesource.jansi.AnsiConsole;

public class ManHunt {

    static Hunter hero0 = new Hunter();
    static Enemy enemy0 = new Enemy();
    static FileUtil fileutil = new FileUtil();

    static Scanner input = new Scanner(System.in);

    static String menu, ask1 = null, sure = null, exit = null, intro = null, score = null;

    public static void main(String[] args) throws InterruptedException, IOException {

//        AnsiConsole.systemInstall();
        do {
            System.out.println(Util.ANSI_BG_WHITE + Util.DARK_RED + "==================== ============================= ====================");
            System.out.println(Util.ANSI_RESET + Util.ANSI_BG_WHITE + "                           Welcome To Manhunt                          ");
            System.out.println(Util.DARK_BLACK + Util.ANSI_BG_WHITE + "                             Version 16.1.1                            ");
            System.out.println(Util.ANSI_BG_WHITE + Util.DARK_RED + "-------------------- ----------------------------- --------------------\n");

            System.out.println(Util.ANSI_RESET + Util.ANSI_BG_WHITE + Util.ANSI_GREEN + ">------------------------------" + Util.ANSI_RESET + Util.DARK_BLACK
                    + Util.ANSI_BG_WHITE + "< Menu >" + Util.ANSI_RESET + Util.ANSI_BG_WHITE + Util.ANSI_GREEN + "-------------------------------<");
            System.out.println(Util.ANSI_RESET + Util.ANSI_BG_WHITE + "1. Start Game                                                          ");
            System.out.println(Util.ANSI_BG_WHITE + "2. Load Game                                                           ");
            System.out.println(Util.ANSI_BG_WHITE + "3. Score Board                                                         ");
            System.out.println(Util.ANSI_BG_WHITE + "4. About                                                               ");
            System.out.println(Util.ANSI_RESET + Util.ANSI_BG_WHITE + "5. " + Util.DARK_RED + "Exit                                                                " + Util.ANSI_RESET);
            System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + " Choose: ");
            menu = input.nextLine();

            if (menu.equals("1")) {
                fileutil.deleteFile("enemybattle.txt");
                fileutil.deleteExistingFile1("enemy.txt");
                fileutil.deleteExistingFile2("hero.txt");

                System.out.print("Skip the introduction ? "
                        + "1 = Yes ( " + Util.ANSI_GREEN + Util.CHECK_MARK + Util.ANSI_RESET + " ), "
                        + "2 = No ( " + Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " )-- ");
                intro = input.nextLine();
                if (intro.equals("1")) {
                    Util.clearScreen();
                    System.out.print("Are you sure you can help them ? "
                            + "1 = Yes ( " + Util.ANSI_GREEN + Util.CHECK_MARK + Util.ANSI_RESET + " ), "
                            + "2 = No ( " + Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " )-- ");
                    sure = input.nextLine();
                    if (sure.equals("1")) {
                        Util.clearScreen();
                        hero0.heroName();
                        Util.clearScreen();
                        beginScreen();
                        hero0.optionToDo();
                    } else if (sure.equals("2")) {
                        hero0.screenClearLoading();
                    } else {
                        System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                        Util.delay(2500);
                        Util.clearScreen();
                    }

                } else if (intro.equals("2")) {
                    Util.clearScreen();
                    introduction();
                    System.out.print("Are you sure you can help them ? "
                            + "1 = Yes ( " + Util.ANSI_GREEN + Util.CHECK_MARK + Util.ANSI_RESET + " ), "
                            + "2 = No ( " + Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " )-- ");
                    sure = input.nextLine();
                    if (sure.equals("1")) {
                        Util.clearScreen();
                        hero0.heroName();
                        Util.clearScreen();
                        beginScreen();
                        hero0.optionToDo();
                    } else if (sure.equals("2")) {
                        hero0.screenClearLoading();
                    } else {
                        System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                        Util.delay(2500);
                        Util.clearScreen();
                    }

                } else {
                    System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                    Util.delay(2500);
                    Util.clearScreen();

                }

            } else if (menu.equals("2")) {
                fileutil.deleteFile("enemybattle.txt");
                hero0.loadGameHero();
                enemy0.loadGameEnemy();
                hero0.setEnemy(enemy0);
                hero0.screenClearLoading();
                hero0.optionToDo();
            } else if (menu.equals("3")) {
                Util.clearScreen();
                // read file
                // open existing file to read
                try {
                    String s5 = fileutil.openReadFile("scoreBoard.txt");
//                    System.out.println(s5);

                    String tmp = "";

                    while (fileutil.getReadScanner().hasNext()) {
                        // read line per line, split line by comma delimiter
                        tmp = tmp + fileutil.getReadScanner().next();

//                        String[] readLine = fileutil.getReadScanner().next().split(",");
//
//                        // printout per line
//                        String name3 = readLine[0];
//                        int level3 = Integer.parseInt(readLine[1]);
//                        int exp4 = Integer.parseInt(readLine[2]);
//                        int hp3 = Integer.parseInt(readLine[3]);
//                        int att3 = Integer.parseInt(readLine[4]);
//                        int deff3 = Integer.parseInt(readLine[5]);
//                        int money3 = Integer.parseInt(readLine[6]);
//                        System.out.printf("%s,%d,%d,%d,%d,%d,%d%n", name3, level3, exp4, hp3, att3, deff3, money3);
                    }

                    //close opening read file
                    String s6 = fileutil.closeReadFile();
//                    System.out.println(s6);

                    String[] scoreline = tmp.split(";");
                    System.out.println("Name\t\tLevel\t\tMoney\t\tDay\t\tScore");
                    System.out.println("=======================================================================");
                    for (String s : scoreline) {
                        String[] scell = s.split(",");
                        System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t%s%n", scell[0], scell[1], scell[2], scell[3], scell[4]);
                    }

                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
                System.out.println("1. Back");
                System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + " Choose : ");
                exit = input.nextLine();
                if (exit.equals("1")) {
                    Util.clearScreen();

                } else {
                    System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                    Util.delay(2500);
                    Util.clearScreen();
                }
            } else if (menu.equals("4")) {
                Util.clearScreen();
                System.out.println(Util.ANSI_BLUE + "Made by" + Util.ANSI_RESET + Util.DARK_BLUE + " : PierryRajadi  ("
                        + Util.DARK_BLACK + "00000024057" + Util.ANSI_BLUE + ")");
                System.out.println(Util.DARK_BLUE + "          ValerieLeonie ("
                        + Util.DARK_BLACK + "00000022818" + Util.DARK_BLUE + ")" + Util.ANSI_RESET);
                System.out.println(Util.ANSI_BLUE + "Information System of UPH Medan Intake 2016");
                System.out.println("");
                System.out.println("Last Upadated :"+Util.DARK_BLACK+" 03 Desember 2016"+Util.ANSI_RESET);
                System.out.println("1. Back");
                System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + " Choose : ");
                score = input.nextLine();
                if (score.equals("1")) {

                } else {
                    System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                    Util.delay(2500);
                }
                Util.clearScreen();
            } else if (menu.equals("5")) {
                System.out.print("Are you sure ? 1 = Yes ( " + Util.ANSI_GREEN + Util.CHECK_MARK + Util.ANSI_RESET + " )"
                        + ", 2 = No ( " + Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " )-- ");
                ask1 = input.nextLine();

                if (ask1.equals("1")) {
                    System.out.println(Util.DARK_RED + "=============================================================");
                    System.out.println(Util.DARK_RED + "                        BYE-BYE !                            ");
                    System.out.println(Util.DARK_RED + "=============================================================" + Util.ANSI_RESET);
                    System.exit(0);
                } else if (ask1.equals("2")) {
                    Util.clearScreen();
                } else {
                    System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                }
            } else {
                System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
                Util.delay(3000);
                Util.clearScreen();
            }
        } while (!menu.equals("1") || !menu.equals("2") || !menu.equals("3") || !menu.equals("4") || !menu.equals("5")
                || !ask1.equals("1") || !ask1.equals("2")
                || !sure.equals("1") || !sure.equals("2")
                || !exit.equals("1")
                || !intro.equals("1") || !intro.equals("2"));

    }

    public static void introduction() throws InterruptedException {

        Util.clearScreen();
        Util.delay(100);
        System.out.print(Util.ANSI_BLUE + "A");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " boy");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " is");
        Util.delay(300);
        System.out.print(Util.DARK_RED + " gone");
        Util.delay(300);
        System.out.print(Util.DARK_RED + ".");
        Util.delay(300);
        System.out.print(Util.DARK_RED + ".");
        Util.delay(300);
        System.out.println(Util.DARK_RED + "." + Util.ANSI_RESET);
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "It's");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " the");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " 27th");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " time");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " already");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " that");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " a");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " boy");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " is");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " gone");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " without");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " any");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + " trace");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ".");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "No ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "one ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "knows ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "about ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "their ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "existence");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ".");
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "They ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "might ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "run ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "away");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + ", ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "gotten ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "lost");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + ", ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "eaten ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "by ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "the ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "monster");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ",");
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "or ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "simply ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "haven't ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "called ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "home ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "in ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "a ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "while");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ".");
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "Their ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "family ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "miss ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "them ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "and ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "need ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "them ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "returned");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ".");
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "But");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + ",");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "the ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "only ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "information ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "is ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "the ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "last ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "time ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "someone ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "saw ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "them");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ",");
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "they ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "were ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "heading ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "to ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "the ");
        Util.delay(300);
        System.out.print(Util.DARK_RED + "forbidden ");
        Util.delay(300);
        System.out.print(Util.DARK_RED + "forest");
        Util.delay(300);
        System.out.print(Util.DARK_RED + ".");
        Util.delay(500);
        System.out.print(Util.DARK_RED + ".");
        Util.delay(500);
        System.out.println(Util.DARK_RED + "." + Util.ANSI_RESET);
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "As ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "the " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.ANSI_GREEN + "guardian " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "of ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "the ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "town");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + ",");
        Util.delay(500);
        System.out.print(Util.ANSI_BLUE + "you ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "are ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "called ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "in ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "to ");
        Util.delay(300);
        System.out.print(Util.DARK_RED + "find " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "them " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "and " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.DARK_RED + "bring " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "them ");
        Util.delay(300);
        System.out.print(Util.ANSI_BLUE + "back");
        Util.delay(300);
        System.out.println(Util.ANSI_BLUE + "." + Util.ANSI_RESET);
        Util.delay(500);
        System.out.print(Util.DARK_RED + "S " + Util.ANSI_RESET);
        Util.delay(300);
        System.out.print(Util.DARK_RED + "A ");
        Util.delay(300);
        System.out.print(Util.DARK_RED + "F ");
        Util.delay(300);
        System.out.print(Util.DARK_RED + "E ");
        Util.delay(300);
        System.out.print(Util.DARK_RED + "L ");
        Util.delay(300);
        System.out.println(Util.DARK_RED + "Y" + Util.ANSI_RESET);
        Util.delay(300);
    }

    public static void beginScreen() throws InterruptedException {
        Util.clearScreen();
        System.out.print(Util.ANSI_GREEN + "B");
        Util.delay(300);
        System.out.print(Util.ANSI_GREEN + " E");
        Util.delay(300);
        System.out.print(Util.ANSI_GREEN + " G");
        Util.delay(300);
        System.out.print(Util.ANSI_GREEN + " I");
        Util.delay(300);
        System.out.print(Util.ANSI_GREEN + " N");
        Util.delay(300);
        System.out.print(Util.ANSI_GREEN + " .");
        Util.delay(400);
        System.out.print(Util.ANSI_GREEN + " .");
        Util.delay(400);
        System.out.print(Util.ANSI_GREEN + " .");
        Util.delay(400);
        Util.clearScreen();
    }

}
