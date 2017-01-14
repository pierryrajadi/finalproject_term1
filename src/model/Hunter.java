package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import util.FileUtil;
import util.Util;
import java.util.Scanner;
import java.util.Random;

public class Hunter {

//    //Start Menu
//    private String menu;
//    private String ask1;
//    private String sure;
    //Input
    private String action;
    private String choose;
    private String ask2;

    //Shop
    private String shop;
    private String potion;
    private String weapon;
    private String armor;

    //Hero
    private String name;
    private int exp = 0;
    private int exp1 = 0;
    private int level = 1;
    private int e = 100;
    private int lvl = 0;
    private int hp = 100;
    private int xhp = 100;
    private int att = 10;
    private int deff = 6;

    //$$$
    private int money = 500;
    private int uang = 0;
    private int price;

    //Limit Days
    private int day = 1;
    private int days = 365;

    //Score
    private int score = 0;
    private int xscore = 0;

    Scanner input = new Scanner(System.in);
    Scanner num = new Scanner(System.in);

    Random random = new Random();
    Enemy enemy = new Enemy();
    FileUtil fileutil = new FileUtil();

    public Hunter() {

    }
//
//    public Hunter(String name27, int level27, int exp27, int hp27, int hp28, int att27, int deff27, int money27, int day27) {
//        this.name = name27;
//        this.level = level27;
//        this.exp = exp27;
//        this.hp = hp27;
//        this.xhp = hp28;
//        this.att = att27;
//        this.deff = deff27;
//        this.money = money27;
//        this.day = day27;
//
//    }

    public void loadGameHero() {
        // read file
        // open existing file to read
        try {
            String s5 = fileutil.openReadFile("hero.txt");
//            System.out.println(s5);

            while (fileutil.getReadScanner().hasNext()) {
                // read line per line, split line by comma delimiter

                String[] readLine = fileutil.getReadScanner().next().split(",");

                // printout per line
                String name27 = readLine[0];
                int level27 = Integer.parseInt(readLine[1]);
                int exp27 = Integer.parseInt(readLine[2]);
                int exp28 = Integer.parseInt(readLine[3]);
                int hp27 = Integer.parseInt(readLine[4]);
                int hp28 = Integer.parseInt(readLine[5]);
                int att27 = Integer.parseInt(readLine[6]);
                int deff27 = Integer.parseInt(readLine[7]);
                int money27 = Integer.parseInt(readLine[8]);
                int day27 = Integer.parseInt(readLine[9]);
                int score27 = Integer.parseInt(readLine[10]);
//                System.out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s%n", name27, level27, exp27, hp27, hp28, att27, deff27, money27, day27);
                name = name27;
                level = level27;
                exp = exp27;
                e = exp28;
                hp = hp27;
                xhp = hp28;
                att = att27;
                deff = deff27;
                money = money27;
                day = day27;
                score = score27;
            }

            //close opening read file
            String s6 = fileutil.closeReadFile();
//            System.out.println(s6);

        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
        }
    }

    public void heroName() {
        System.out.println("Let us know your name");
        System.out.print("Input your name : ");
        name = input.nextLine();
    }

    public void optionToDo() throws InterruptedException, IOException {

        do {

            System.out.println(Util.ANSI_GREEN + ">---------" + Util.ANSI_RESET
                    + Util.DARK_BLACK + "< Action >" + Util.ANSI_RESET + Util.ANSI_GREEN + "---------<" + Util.ANSI_RESET + " (" + day + "/" + Util.ANSI_RED + days + Util.ANSI_RESET + ")");
            System.out.println("1. Show your status");
            System.out.println("2. Battle");
            System.out.println("3. Shop");
            System.out.println("4. Save Game");
            System.out.println(Util.ANSI_RESET + "5. " + Util.DARK_RED + "Exit" + Util.ANSI_RESET);
            System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + " Action : ");
            action = num.nextLine();

//            screenClearLoading();
            if (action.equals("1")) {
                Util.clearScreen();
                heroStatus();
            } else if (action.equals("2")) {
                Util.clearScreen();
                battle();
            } else if (action.equals("3")) {
                Util.clearScreen();
                shopBuy();
            } else if (action.equals("4")) {
                Util.clearScreen();
                saveGameHero();
                enemy.saveGameEnemy();
            } else if (action.equals("5")) {
                Util.clearScreen();
                exitGame();
                Util.clearScreen();
            } else {
                System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input is Wrong. Please Try Again.");
                Util.delay(2000);
                Util.clearScreen();
            }
            missionFailed();
            if (money < 1) {
                money = 0;
            }

        } while (!action.equals("1") || !action.equals("2") || !action.equals("3") || !action.equals("4") || !action.equals("5")
                || !choose.equals("1") || !choose.equals("2") || !choose.equals("3")
                || !shop.equals("1") || !shop.equals("2") || !shop.equals("3") || !shop.equals("4")
                || !potion.equals("1") || !potion.equals("2") || !potion.equals("3") || !potion.equals("4")
                || !weapon.equals("1") || !weapon.equals("2") || !weapon.equals("3") || !weapon.equals("4") || !weapon.equals("5")
                || !weapon.equals("6") || !weapon.equals("7") || !weapon.equals("8") || !weapon.equals("9")
                || !armor.equals("1") || !armor.equals("2") || !armor.equals("3") || !armor.equals("4") || !armor.equals("5")
                || !armor.equals("6") || !armor.equals("7") || !armor.equals("8") || !armor.equals("9") || !armor.equals("10")
                || !armor.equals("11") || !armor.equals("12") || !armor.equals("13") || !armor.equals("14")
                || !ask2.equals("1") || !ask2.equals("2"));
    }

    public void missionFailed() throws InterruptedException, IOException {
        if (day >= 365) {
            System.out.print(Util.DARK_RED + "MISSION " + Util.ANSI_RESET);
            Util.delay(500);
            System.out.println(Util.DARK_RED + "FAILED" + Util.ANSI_RESET);
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "You ");
            Util.delay(500);
            System.out.println(Util.ANSI_RED + "die.");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "The ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "family ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "feel ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "so ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "stressed ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "and ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "they ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "decided ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "to ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "kill ");
            Util.delay(500);
            System.out.println(Util.ANSI_RED + "themself. ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "And ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "the ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "boy ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "is ");
            Util.delay(500);
            System.out.println(Util.ANSI_RED+"gone ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "for ");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + "forever");
            Util.delay(500);
            System.out.print(Util.ANSI_RED + ".");
            Util.delay(500);
            System.out.print(Util.ANSI_RED+"Game ");
            Util.delay(500);
            System.out.println(Util.ANSI_RED+"over.");
            Util.delay(500);
            System.out.print(Util.ANSI_RED+".");
            Util.delay(800);
            System.out.print(Util.ANSI_RED+".");
            Util.delay(800);
            System.out.print(Util.ANSI_RED+".");
            Util.delay(1500);
            saveScoreBoard();
            Util.clearScreen();
            System.exit(0);
        }
    }

    public void heroStatus() {

        System.out.println("");
        System.out.println(Util.DARK_BLUE + ">--------------------------" + Util.DARK_BLACK + "< Status >"
                + Util.DARK_BLUE + "--------------------------<");
        System.out.println(Util.DARK_BLUE + ">|" + Util.ANSI_RESET + "  Name    : " + name);
        System.out.println(Util.DARK_BLUE + ">|" + Util.ANSI_RESET + "  Level   : " + level + "\t\t" + "Exp\t: " + exp + "/" + e);
        System.out.println(Util.DARK_BLUE + ">|" + Util.ANSI_RESET + "  HP\t    : " + hp + "/" + xhp);
        System.out.println(Util.DARK_BLUE + ">|" + Util.ANSI_RESET + "  Attack  : " + att + "\tMoney   : " + money);
        System.out.println(Util.DARK_BLUE + ">|" + Util.ANSI_RESET + "  Defense : " + deff + "\t\tScore   : " + score);
        System.out.println(Util.DARK_BLUE + ">--------------------------------------------------------------<");
        System.out.println("");
    }

    public void battle() throws InterruptedException, IOException {
        enemy.loadGameEnemyBattle();
        Util.clearScreen();
        // load game true, not random
        if (enemy != null && enemy.getLoadenemystatus() == true) {
            Util.clearScreen();
            heroStatus();
            enemy.enemyStatus();
            battleMenu();
        } else { // load game false, random the enemy      
            heroStatus();
            enemy.enemyLevel();
            enemy.enemyStatus();
            battleMenu();
        }

    }

    public void battleMenu() throws InterruptedException, IOException {
        do {
            levelUp();
            System.out.println("");
            System.out.println(Util.ANSI_GREEN + ">---------------" + Util.ANSI_RESET
                    + Util.DARK_BLACK + "< Battle >" + Util.ANSI_RESET + Util.ANSI_GREEN + "---------------<" + Util.ANSI_RESET);
            System.out.println("1. Attack " + Util.ANSI_BLUE + "(Day +1)" + Util.ANSI_RESET);
            System.out.println("2. Find a new enemy " + Util.ANSI_BLUE + "(Money -200, Day +1)" + Util.ANSI_RESET);
            System.out.println("3. Back");
            System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + " Choose : ");
            choose = num.nextLine();
            System.out.println("");

            if (choose.equals("1")) {
//                screenClearBattle();
                System.out.println(Util.ANSI_YELLOW + ">------------------------------------------------------------<");
                enemy.damageToEnemy(getAtt());
                damageToHero(enemy.getAtt());
                if (enemy.getLevel() <= 10) {
                    uang += Util.randInt(35, 45);
                } else if (enemy.getLevel() > 10 && enemy.getLevel() <= 20) {
                    uang += Util.randInt(40, 50);
                } else if (enemy.getLevel() > 20 && enemy.getLevel() <= 30) {
                    uang += Util.randInt(45, 55);
                } else if (enemy.getLevel() > 30 && enemy.getLevel() <= 40) {
                    uang += Util.randInt(50, 60);
                } else if (enemy.getLevel() > 40 && enemy.getLevel() <= 50) {
                    uang += Util.randInt(55, 65);
                } else if (enemy.getLevel() > 50 && enemy.getLevel() <= 60) {
                    uang += Util.randInt(60, 70);
                } else if (enemy.getLevel() > 60 && enemy.getLevel() <= 70) {
                    uang += Util.randInt(65, 75);
                } else if (enemy.getLevel() > 70 && enemy.getLevel() <= 80) {
                    uang += Util.randInt(70, 80);
                } else if (enemy.getLevel() > 80 && enemy.getLevel() <= 90) {
                    uang += Util.randInt(75, 85);
                } else if (enemy.getLevel() > 90 && enemy.getLevel() <= 100) {
                    uang += Util.randInt(80, 90);
                }

                gainExp1();
                heroScore();
                System.out.println(Util.ANSI_YELLOW + ">|" + Util.ANSI_RESET + " You get Exp   : " + exp1);
                System.out.println(Util.ANSI_YELLOW + ">|" + Util.ANSI_RESET + " You get Money : " + uang);
                System.out.println(Util.ANSI_YELLOW + ">|" + Util.ANSI_RESET + " You get Score : " + xscore);
                money += uang;
                uang = 0;
                exp += exp1;
                exp1 = 0;
                score += xscore;
                xscore = 0;
                System.out.println(Util.ANSI_YELLOW + ">------------------------------------------------------------<");
                heroStatus();
                enemy.enemyStatus();
                levelUp();
                if (hp < 1) {
                    System.out.print(Util.DARK_RED + "MISSION " + Util.ANSI_RESET);
                    Util.delay(500);
                    System.out.println(Util.DARK_RED + "FAILED" + Util.ANSI_RESET);
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "You ");
                    Util.delay(500);
                    System.out.println(Util.ANSI_RED + "die.");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "The ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "family ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "feel ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "so ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "stressed ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "and ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "they ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "decided ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "to ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "kill ");
                    Util.delay(500);
                    System.out.println(Util.ANSI_RED + "themself. ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "And ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "the ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "boy ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "is ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "gone ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "for ");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "forever");
                    Util.delay(500);
                    System.out.println(Util.ANSI_RED + ".");
                    Util.delay(500);
                    System.out.print(Util.ANSI_RED + "G");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "A");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "M");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "E ");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "O");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "V");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "E");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + "R ");
                    Util.delay(300);
                    System.out.print(Util.ANSI_RED + ".");
                    Util.delay(800);
                    System.out.print(Util.ANSI_RED + ".");
                    Util.delay(800);
                    System.out.print(Util.ANSI_RED + ".");
                    Util.delay(1500);
                    Util.clearScreen();
                    saveScoreBoard();
                    System.exit(0);

                } else if (enemy.getHp() < 1) {
                    System.out.println(Util.ANSI_PURPLE + enemy.getName() + " die.");

                    if (enemy.getLevel() <= 10) {
                        uang += Util.randInt(100, 120);
                    } else if (enemy.getLevel() > 10 && enemy.getLevel() <= 20) {
                        uang += Util.randInt(115, 125);
                    } else if (enemy.getLevel() > 20 && enemy.getLevel() <= 30) {
                        uang += Util.randInt(120, 130);
                    } else if (enemy.getLevel() > 30 && enemy.getLevel() <= 40) {
                        uang += Util.randInt(125, 135);
                    } else if (enemy.getLevel() > 40 && enemy.getLevel() <= 50) {
                        uang += Util.randInt(130, 140);
                    } else if (enemy.getLevel() > 50 && enemy.getLevel() <= 60) {
                        uang += Util.randInt(135, 145);
                    } else if (enemy.getLevel() > 60 && enemy.getLevel() <= 70) {
                        uang += Util.randInt(140, 150);
                    } else if (enemy.getLevel() > 70 && enemy.getLevel() <= 80) {
                        uang += Util.randInt(145, 155);
                    } else if (enemy.getLevel() > 80 && enemy.getLevel() <= 90) {
                        uang += Util.randInt(150, 160);
                    } else if (enemy.getLevel() > 90 && enemy.getLevel() <= 100) {
                        uang += Util.randInt(155, 165);
                    }
                    System.out.println("You get " + uang + " money.");
                    System.out.println("");
                    money += uang;
                    System.out.println(Util.ANSI_RED + ">-----------------------" + Util.ANSI_RESET
                            + Util.DARK_BLACK + "< Next Enemy >" + Util.ANSI_RESET + Util.ANSI_RED + "-----------------------<" + Util.ANSI_RESET);
                    enemy.getNewEnemy();
                    System.out.println(Util.ANSI_RED + ">-------------------------------------------------------------<");
                    optionToDo();
                }
                day++;
                missionFailed();
            } else if (choose.equals("2")) {
                price = 200;
                if (money > price) {
                    money -= price;
                    screenClearFindNewEnemy();
                    enemy.enemyLevel();
                    findNewEnemy();
                    heroStatus();
                    enemy.enemyStatus();
                    day++;
                    missionFailed();
                } else if (money < price) {
                    Util.clearScreen();
                    System.out.println("Sorry, you don't have enough money to find new enemy.");
                    battle();
                }
            } else if (choose.equals("3")) {
                enemy.saveGameEnemyBattle();
                screenClearLoading();
                optionToDo();
            } else {
                System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input is Wrong. Please Try Again.");
                Util.delay(2000);
                Util.clearScreen();
            }

            //Victory story
            victoryStory();

        } while (choose.equals("1") || choose.equals("2"));

    }

    public void victoryStory() throws InterruptedException, IOException {
        if (level == 50) {
            System.out.print(Util.ANSI_GREEN+"You've ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"reached ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"level ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"50");
            Util.delay(300);
            System.out.println(Util.ANSI_GREEN+"!");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"You ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"found ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"out ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"that ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"all ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"boys ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"was ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"trapped ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"deeply ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"inside ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"the ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"forbidden ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"forest");
            Util.delay(300);
            System.out.println(Util.ANSI_GREEN+",");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"been ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"locked ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"to ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"be ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"eaten ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"by ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"the ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"monsters");
            Util.delay(300);
            System.out.println(Util.ANSI_GREEN+".");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"You ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"killed ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"all ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"the ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"monsters ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"and ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"released ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"the ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"boys ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"and ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"bring ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"them ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"back ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"safely ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"to ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"their ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"family");
            Util.delay(300);
            System.out.println(Util.ANSI_GREEN+". ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"T");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"H");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"E ");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"E");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"N");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+"D");
            Util.delay(300);
            System.out.print(Util.ANSI_GREEN+".");
            Util.delay(5000);

            Util.clearScreen();
            saveScoreBoard();
            System.exit(0);

        }
    }

    public void findNewEnemy() {
        System.out.println(Util.ANSI_RED + ">-----------------------" + Util.ANSI_RESET
                + Util.DARK_BLACK + "< New Enemy >" + Util.ANSI_RESET + Util.ANSI_RED + "------------------------<");
        enemy.getNewEnemy();
        System.out.println(Util.ANSI_RED + ">-------------------------------------------------------------<");
        System.out.println("");
    }

    public void shopBuy() throws InterruptedException, IOException {
        System.out.println(Util.ANSI_GREEN + ">---------" + Util.ANSI_RESET + Util.DARK_BLACK
                + "< SHOP >" + Util.ANSI_RESET + Util.ANSI_GREEN + "---------<" + Util.ANSI_RESET);
        System.out.println("1. Buy Potion");
        System.out.println("2. Buy Weapon");
        System.out.println("3. Buy Armor");
        System.out.println("4. Back");
        System.out.printf(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + Util.ANSI_CYAN + " Can i help you ? --" + Util.ANSI_RESET);
        shop = input.nextLine();

        if (shop.equals("1")) {
            screenClearLoading();
            buyPotion();
        } else if (shop.equals("2")) {
            screenClearLoading();
            buyWeapon();
        } else if (shop.equals("3")) {
            screenClearLoading();
            buyArmor();
        } else if (shop.equals("4")) {
            screenClearLoading();
            optionToDo();
        } else {
            System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input is Wrong. Please Try Again.");
            Util.delay(2000);
            Util.clearScreen();
        }
        if (money < 1) {
            money = 0;
        }
    }

    public void buyPotion() throws InterruptedException, IOException {
        System.out.println(Util.ANSI_GREEN + ">-----------------------" + Util.ANSI_RESET + Util.DARK_BLACK
                + "< Potion >" + Util.ANSI_RESET + Util.ANSI_GREEN + "-----------------------<" + Util.ANSI_RESET);
        System.out.println("1. Small potion (HP : " + Util.ANSI_BLUE + "+10" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-100" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("2. Normal potion (HP : " + Util.ANSI_BLUE + "+20" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-200" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("3. Big potion (HP : " + Util.ANSI_BLUE + "+50" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-300" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("4. Back");
        System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + Util.ANSI_CYAN + " What do you want to buy ? -- " + Util.ANSI_RESET);
        potion = input.nextLine();

        if (potion.equals("1")) {
            screenClearLoading();
            price = 100;
            if (money > price) {
                hp += 10;
                money -= price;
                if (hp >= xhp) {
                    hp = xhp;
                }
                System.out.println("You buy Small Potion," + Util.ANSI_PURPLE + " Your HP " + hp + ", Money left " + money);
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyPotion();
            }
        } else if (potion.equals("2")) {
            screenClearLoading();
            price = 200;
            if (money > price) {
                hp += 20;
                money -= price;
                if (hp >= xhp) {
                    hp = xhp;
                }
                System.out.println("You buy Normal Potion," + Util.ANSI_PURPLE + " Your HP " + hp + ", Money left " + money);
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyPotion();
            }

        } else if (potion.equals("3")) {
            screenClearLoading();
            price = 300;
            if (money > price) {
                hp += 50;
                money -= price;
                if (hp >= xhp) {
                    hp = xhp;
                }
                System.out.println("You buy Big Potion," + Util.ANSI_PURPLE + " Your HP " + hp + ", Money left " + money);
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyPotion();
            }
        } else if (potion.equals("4")) {
            screenClearLoading();
            shopBuy();
        } else {
            System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + "Your Input is Wrong. Please Try Again.");
            Util.delay(2000);
            Util.clearScreen();
        }

        if (money < 1) {
            money = 0;
        }
    }

    public void buyWeapon() throws InterruptedException, IOException {
        System.out.println(Util.ANSI_GREEN + ">-----------------------" + Util.ANSI_RESET + Util.DARK_BLACK
                + "< Weapon >" + Util.ANSI_RESET + Util.ANSI_GREEN + "-----------------------<" + Util.ANSI_RESET);
        System.out.println("1. Dagger (Attack : " + Util.ANSI_BLUE + "+3" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1200" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("2. Normal Sword (Attack : " + Util.ANSI_BLUE + "+5" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1550" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("3. Axe (Attack : " + Util.ANSI_BLUE + "+6" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1700" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("4. Sai (Attack : " + Util.ANSI_BLUE + "+7" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-2000" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("5. Bow & Arrow (Attack : " + Util.ANSI_BLUE + "+9" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-2400" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("6. Battle Axe (Attack : " + Util.ANSI_BLUE + "+12" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-2900" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("7. Bastard Sword (Attack : " + Util.ANSI_BLUE + "+15" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-3300" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("8. Katana (Attack : " + Util.ANSI_BLUE + "+18" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-3800" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("9. Back");
        System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + Util.ANSI_CYAN + " What do you want to buy ? --" + Util.ANSI_RESET);
        weapon = input.nextLine();

        if (weapon.equals("1")) {
            screenClearLoading();
            price = 1200;
            if (money > price) {
                att += 3;
                money -= price;
                System.out.println("You buy Dagger" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("2")) {
            screenClearLoading();
            price = 1550;
            if (money > price) {
                att += 5;
                money -= price;
                System.out.println("You buy Normal Sword" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("3")) {
            screenClearLoading();
            price = 1700;
            if (money > price) {
                att += 6;
                money -= price;
                System.out.println("You buy Axe" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("4")) {
            screenClearLoading();
            price = 2000;
            if (money > price) {
                att += 7;
                money -= price;
                System.out.println("You buy Sai" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("5")) {
            screenClearLoading();
            price = 2400;
            if (money > price) {
                att += 9;
                money -= price;
                System.out.println("You buy Bow & Arrow" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("6")) {
            screenClearLoading();
            price = 2900;
            if (money > price) {
                att += 12;
                money -= price;
                System.out.println("You buy Battle Axe" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("7")) {
            screenClearLoading();
            price = 3300;
            if (money > price) {
                att += 15;
                money -= price;
                System.out.println("You buy Bastard Sword" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("8")) {
            screenClearLoading();
            price = 3800;
            if (money > price) {
                att += 18;
                money -= price;
                System.out.println("You buy Katana" + Util.ANSI_PURPLE + " (Your Attack " + att + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyWeapon();
            }
        } else if (weapon.equals("9")) {
            screenClearLoading();
            shopBuy();
        } else {
            System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input is Wrong. Please Try Again.");
            Util.delay(2000);
            Util.clearScreen();
        }

        if (money < 1) {
            money = 0;
        }
    }

    public void buyArmor() throws InterruptedException, IOException {
        System.out.println(Util.ANSI_GREEN + ">------------------------" + Util.ANSI_RESET + Util.DARK_BLACK
                + "< Armor >" + Util.ANSI_RESET + Util.ANSI_GREEN + "------------------------<" + Util.ANSI_RESET);
        System.out.println("1. Wood Armor (Defense : " + Util.ANSI_BLUE + "+2" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-990" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("2. Battle Armor (Defense : " + Util.ANSI_BLUE + "+5" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1300" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("3. Metal Armor (Defense : " + Util.ANSI_BLUE + "+9" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-2000" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("4. Evil Bet (Defense : " + Util.ANSI_BLUE + "+2" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-800" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("5. Epic Bet (Defense : " + Util.ANSI_BLUE + "+4" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1700" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("6. Grand Boots (Defense : " + Util.ANSI_BLUE + "+3" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1100" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("7. Metal Boots (Defense : " + Util.ANSI_BLUE + "+5" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1900" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("8. High Grade Boots (Defense : " + Util.ANSI_BLUE + "+7" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-2250" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("9. Common Cloth (Defense : " + Util.ANSI_BLUE + "+4" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1500" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("10. Elegant Cloth (Defense : " + Util.ANSI_BLUE + "+5" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1800" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("11. Cloth Glove (Defense : " + Util.ANSI_BLUE + "+3" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-750" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("12. Metal Glove (Defense : " + Util.ANSI_BLUE + "+7" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-1600" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("13. Elegant Hat (Defense : " + Util.ANSI_BLUE + "+3" + Util.ANSI_RESET
                + ", Money : " + Util.ANSI_RED + "-800" + Util.ANSI_RESET
                + ", Day : " + Util.ANSI_BLUE + "+1" + Util.ANSI_RESET + ")");
        System.out.println("14. Back");
        System.out.print(Util.DARK_BLACK + ">>>>" + Util.ANSI_RESET + Util.ANSI_CYAN + " What do you want to buy ? --" + Util.ANSI_RESET);
        armor = input.nextLine();

        if (armor.equals("1")) {
            screenClearLoading();
            price = 990;
            if (money > price) {
                deff += 2;
                money -= price;
                System.out.println("You buy Wood Armor" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("2")) {
            screenClearLoading();
            price = 1300;
            if (money > price) {
                deff += 5;
                money -= price;
                System.out.println("You buy Battle Armor" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("3")) {
            screenClearLoading();
            price = 2000;
            if (money > price) {
                deff += 9;
                money -= price;
                System.out.println("You buy Metal Armor" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("4")) {
            screenClearLoading();
            price = 800;
            if (money > price) {
                deff += 2;
                money -= price;
                System.out.println("You buy Evil Bet" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("5")) {
            screenClearLoading();
            price = 1700;
            if (money > price) {
                deff += 4;
                money -= price;
                System.out.println("You buy Epic Bet" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("6")) {
            screenClearLoading();
            price = 1100;
            if (money > price) {
                deff += 3;
                money -= price;
                System.out.println("You buy Grand Boots" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("7")) {
            screenClearLoading();
            price = 1900;
            if (money > price) {
                deff += 5;
                money -= price;
                System.out.println("You buy Metal Boots" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("8")) {
            screenClearLoading();
            price = 2250;
            if (money > price) {
                deff += 7;
                money -= price;
                System.out.println("You buy High Grade Boots" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("9")) {
            screenClearLoading();
            price = 1500;
            if (money > price) {
                deff += 4;
                money -= price;
                System.out.println("You buy Common Cloth" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("10")) {
            screenClearLoading();
            price = 1800;
            if (money > price) {
                deff += 5;
                money -= price;
                System.out.println("You buy Elegant Cloth" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("11")) {
            screenClearLoading();
            price = 750;
            if (money > price) {
                deff += 3;
                money -= price;
                System.out.println("You buy Cloth Glove" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("12")) {
            screenClearLoading();
            price = 1600;
            if (money > price) {
                deff += 7;
                money -= price;
                System.out.println("You buy Metal Glove" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("13")) {
            screenClearLoading();
            price = 800;
            if (money > price) {
                deff += 3;
                money -= price;
                System.out.println("You buy Elegant Hat" + Util.ANSI_PURPLE + " (Your Defense " + deff + ", Money left " + money + ")");
                System.out.println("");
                day++;
            } else if (money < price) {
                System.out.println("Sorry , you don't have enough money.");
                System.out.println("");
                buyArmor();
            }
        } else if (armor.equals("14")) {
            screenClearLoading();
            shopBuy();
        } else {
            System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input is Wrong. Please Try Again.");
            Util.delay(2000);
            Util.clearScreen();
        }

        if (money < 1) {
            money = 0;
        }
    }

    public void saveGameHero() {
        // open existing file
        String s1 = fileutil.openWriteFile("hero.txt");
//        System.out.println(s1);

        // define text formatting
        String txtFormat1 = "%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n";
        // add record 1
        String name1 = getName();
        int level1 = getLevel();
        int exp2 = getExp();
        int exp3 = getE();
        int hp1 = getHp();
        int hp2 = getXhp();
        int att1 = getAtt();
        int deff1 = getDeff();
        int money1 = getMoney();
        int day1 = getDay();
        int score1 = getScore();

        String s2 = fileutil.addWriteRecord(txtFormat1, name1, level1, exp2, exp3, hp1, hp2, att1, deff1, money1, day1, score1);
//        System.out.println(s2);

        // close opening file
        String s4 = fileutil.closeWriteFile();
//        System.out.println(s4);
    }

    public void exitGame() throws InterruptedException, IOException {
        System.out.print("Are you sure ? 1 = Yes ( " + Util.ANSI_GREEN + Util.CHECK_MARK + Util.ANSI_RESET + " )"
                + ", 2 = No ( " + Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " )-- ");
        ask2 = input.nextLine();

        if (ask2.equals("1")) {
            System.exit(0);
        } else if (ask2.equals("2")) {
            optionToDo();
        } else {
            System.out.println(Util.ANSI_RED + Util.ERROR_MARK + Util.ANSI_RESET + " Your Input Is Wrong. Please Try Again.");
            Util.delay(2000);
            Util.clearScreen();
        }
    }

    public void gainExp1() {
        if (enemy.getLevel() <= 10) {
            exp1 += Util.randInt(5, 10);
        } else if (enemy.getLevel() > 10 && enemy.getLevel() <= 20) {
            exp1 += Util.randInt(11, 15);
        } else if (enemy.getLevel() > 20 && enemy.getLevel() <= 30) {
            exp1 += Util.randInt(16, 20);
        } else if (enemy.getLevel() > 30 && enemy.getLevel() <= 40) {
            exp1 += Util.randInt(21, 25);
        } else if (enemy.getLevel() > 40 && enemy.getLevel() <= 50) {
            exp1 += Util.randInt(26, 30);
        } else if (enemy.getLevel() > 50 && enemy.getLevel() <= 60) {
            exp1 += Util.randInt(31, 35);
        } else if (enemy.getLevel() > 60 && enemy.getLevel() <= 70) {
            exp1 += Util.randInt(36, 40);
        } else if (enemy.getLevel() > 70 && enemy.getLevel() <= 80) {
            exp1 += Util.randInt(41, 45);
        } else if (enemy.getLevel() > 80 && enemy.getLevel() <= 90) {
            exp1 += Util.randInt(46, 50);
        } else if (enemy.getLevel() > 90 && enemy.getLevel() <= 100) {
            exp1 += Util.randInt(51, 55);
        }
    }

    public void levelUp() {
//        if (exp <= 100) {
//            } 
        if (exp > e) {
            lvl += 1;
            hp += 50;
            xhp += 50;
            att += 3;
            deff += 2;
            e += 100;
            money += 250;
            System.out.println(Util.DARK_MAGENTA + "|--> You just level up. <--|");
        }
        this.level += lvl;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getXhp() {
        return xhp;
    }

    public int getDeff() {
        return deff;
    }

    public int getAtt() {
        return att;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getE() {
        return e;
    }

    public int getExp1() {
        return exp1;
    }

    public int getMoney() {
        return money;
    }

    public int getDay() {
        return day;
    }

    public int getDays() {
        return days;
    }

    public int getScore() {
        return score;
    }

    public void damageToHero(int damage) {
        hp = hp - (damage - getDeff());
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(Util.ANSI_YELLOW + "|| " + Util.ANSI_RESET + name + " has " + hp + " HP left.");
    }

    public void saveScoreBoard() throws IOException {
        String tmp = "";
//        fileutil.openWriteFile("scoreBoard.txt");
//        fileutil.closeWriteFile();
        Path path = Paths.get("scoreBoard.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
            //--------------
            String s5 = fileutil.openReadFile("scoreBoard.txt");
//            System.out.println(s5);

            while (fileutil.getReadScanner().hasNext()) {
                // read line per line, split line by comma delimiter
                tmp = tmp + fileutil.getReadScanner().next();
            }
            String s6 = fileutil.closeReadFile();
//            System.out.println(s6);
            //---------------

            String s7 = fileutil.openWriteFile("scoreBoard.txt");
//            System.out.println(s7);
            String txtFormat1 = "%s,%d,%d,%d,%d;%n";

            String[] scoreline = tmp.split(",");
            if (scoreline != null && scoreline.length > 0) {
                for (String s : scoreline) {
//            System.out.println(s);
                    if (s != null && !s.isEmpty()) {
                        String[] scell = s.split(";");
                        String name99 = scell[0];
                        int level99 = Integer.parseInt(scell[1]);
                        int money99 = Integer.parseInt(scell[2]);
                        int day99 = Integer.parseInt(scell[3]);
                        int score99 = Integer.parseInt(scell[4]);

                        String s9 = fileutil.addWriteRecord(txtFormat1, name99, level99, money99, day99, score99);
//                        System.out.println("ttt" + s9);
                    }

                }
            } else {
            }
            // add record 1
            String name99 = getName();
            int level99 = getLevel();
            int money99 = getMoney();
            int day99 = getDay();
            int score99 = getScore();

            String s2 = fileutil.addWriteRecord(txtFormat1, name99, level99, money99, day99, score99);
//            System.out.println(s2);

            // close opening file
            String s4 = fileutil.closeWriteFile();
//            System.out.println(s4);
        } else {
            //--------------
            String s5 = fileutil.openReadFile("scoreBoard.txt");
//            System.out.println(s5);

            while (fileutil.getReadScanner().hasNext()) {
                // read line per line, split line by comma delimiter
                tmp = tmp + fileutil.getReadScanner().next();
            }
            String s6 = fileutil.closeReadFile();
//            System.out.println(s6);
            //---------------
            String s7 = fileutil.openWriteFile("scoreBoard.txt");
//            System.out.println(s7);
            String txtFormat1 = "%s,%d,%d,%d,%d;%n";

            String[] scoreline = tmp.split(";");
            if (scoreline != null && scoreline.length > 0) {
                for (String s : scoreline) {
//            System.out.println(s);
                    if (s != null && !s.isEmpty()) {
                        String[] scell = s.split(",");
                        String name99 = scell[0];
                        int level99 = Integer.parseInt(scell[1]);
                        int money99 = Integer.parseInt(scell[2]);
                        int day99 = Integer.parseInt(scell[3]);
                        int score99 = Integer.parseInt(scell[4]);

                        String s8 = fileutil.addWriteRecord(txtFormat1, name99, level99, money99, day99, score99);
//                        System.out.println("1231" + s8);
                    }

                }
            } else {
            }
            // add record 1
            String name99 = getName();
            int level99 = getLevel();
            int money99 = getMoney();
            int day99 = getDay();
            int score99 = getScore();

            String s2 = fileutil.addWriteRecord(txtFormat1, name99, level99, money99, day99, score99);
//            System.out.println(s2);

            // close opening file
            String s4 = fileutil.closeWriteFile();
//            System.out.println(s4);
        }

    }

    public void heroScore() {
        if (enemy.getAtt() <= 25) {
            xscore += Util.randInt(100, 200);
        } else if (enemy.getAtt() > 25 && enemy.getAtt() <= 30) {
            xscore += Util.randInt(125, 225);
        } else if (enemy.getAtt() > 30 && enemy.getAtt() <= 35) {
            xscore += Util.randInt(150, 250);
        } else if (enemy.getAtt() > 35 && enemy.getAtt() <= 40) {
            xscore += Util.randInt(175, 275);
        } else if (enemy.getAtt() > 40 && enemy.getAtt() <= 45) {
            xscore += Util.randInt(200, 300);
        } else if (enemy.getAtt() > 45 && enemy.getAtt() <= 50) {
            xscore += Util.randInt(225, 325);
        } else if (enemy.getAtt() > 50 && enemy.getAtt() <= 55) {
            xscore += Util.randInt(250, 350);
        } else if (enemy.getAtt() > 55 && enemy.getAtt() <= 60) {
            xscore += Util.randInt(275, 375);
        } else if (enemy.getAtt() > 60 && enemy.getAtt() <= 65) {
            xscore += Util.randInt(300, 400);
        } else if (enemy.getAtt() > 65 && enemy.getAtt() <= 70) {
            xscore += Util.randInt(325, 425);
        } else if (enemy.getAtt() > 70 && enemy.getAtt() <= 75) {
            xscore += Util.randInt(350, 450);
        } else if (enemy.getAtt() > 75 && enemy.getAtt() <= 80) {
            xscore += Util.randInt(375, 475);
        } else if (enemy.getAtt() > 80 && enemy.getAtt() <= 85) {
            xscore += Util.randInt(400, 500);
        } else if (enemy.getAtt() > 85 && enemy.getAtt() <= 90) {
            xscore += Util.randInt(425, 525);
        } else if (enemy.getAtt() > 90 && enemy.getAtt() <= 95) {
            xscore += Util.randInt(450, 550);
        } else if (enemy.getAtt() > 95 && enemy.getAtt() <= 100) {
            xscore += Util.randInt(475, 575);
        } else if (enemy.getAtt() > 100 && enemy.getAtt() <= 105) {
            xscore += Util.randInt(500, 600);
        } else if (enemy.getAtt() > 105 && enemy.getAtt() <= 110) {
            xscore += Util.randInt(525, 625);
        } else if (enemy.getAtt() > 110 && enemy.getAtt() <= 115) {
            xscore += Util.randInt(150, 250);
        }
    }

    public void screenClearLoading() throws InterruptedException {
        Util.clearScreen();
        System.out.print(Util.DARK_BLACK + "L");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " O");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " A");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " D");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " I");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " N");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " G");
        Util.delay(300);
        System.out.print(Util.DARK_BLACK + " .");
        Util.delay(400);
        System.out.print(Util.DARK_BLACK + " .");
        Util.delay(400);
        System.out.print(Util.DARK_BLACK + " .");
        Util.delay(400);
        Util.clearScreen();
    }

    public void screenClearBattle() throws InterruptedException {
        Util.clearScreen();
        System.out.print(Util.ANSI_RED + "B");
        Util.delay(300);
        System.out.print(Util.ANSI_RED + " A");
        Util.delay(300);
        System.out.print(Util.ANSI_RED + " T");
        Util.delay(300);
        System.out.print(Util.ANSI_RED + " T");
        Util.delay(300);
        System.out.print(Util.ANSI_RED + " L");
        Util.delay(300);
        System.out.print(Util.ANSI_RED + " E");
        Util.delay(300);
        System.out.print(Util.ANSI_RED + " .");
        Util.delay(400);
        System.out.print(Util.ANSI_RED + " .");
        Util.delay(400);
        System.out.print(Util.ANSI_RED + " .");
        Util.delay(400);
        Util.clearScreen();
    }

    public void screenClearFindNewEnemy() throws InterruptedException {
        Util.clearScreen();
        System.out.print(Util.ANSI_CYAN + "F");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " I");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " N");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " D");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " I");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " N");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " G");
        Util.delay(300);
        System.out.print(Util.ANSI_CYAN + " .");
        Util.delay(400);
        System.out.print(Util.ANSI_CYAN + " .");
        Util.delay(400);
        System.out.print(Util.ANSI_CYAN + " .");
        Util.delay(400);
        Util.clearScreen();
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

}
