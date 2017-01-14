package model;

import util.Util;
import java.util.Random;
import util.FileUtil;

public class Enemy {

    private String name;
    private int level;
    private int lvl;
    private int hp;
    private int xhp;
    private int att;
    private int xatt;
    private int deff;
    private int xdeff;

    Random random = new Random();
    FileUtil fileutil = new FileUtil();

    private boolean loadenemystatus = false;

    public Enemy() {
        this.name = getEnemy();
        
    }

//    public Enemy(int lvl2, int hp2, int att2, int deff2) {
//        lvl = lvl2;
//        xhp = hp2;
//        xatt = att2;
//        xdeff = deff2;
//    }
    public String getEnemy() {
        String[] name0 = {"Thalos", "Ethanol", "Thili", "Corwin", "Marx", "Galena", "Treven", "Dyspaire"};
        int i = (int) (Math.random() * 8);
        this.name = name0[i];
        return this.name;
    }

    public void getNewEnemy() {
        String[] name1 = {"Thalos", "Ethanol", "Thili", "Corwin", "Marx", "Galena", "Treven", "Dyspaire"};
        int i = (int) (Math.random() * 8);
        this.name = name1[i];
        enemyLevel();
        System.out.println(Util.ANSI_RED + "||" + Util.ANSI_RESET + " Enemy  : " + name);
        System.out.println(Util.ANSI_RED + "||" + Util.ANSI_RESET + " Level  : " + level + "\t\t"
                + "HP\t: " + hp);
        System.out.println(Util.ANSI_RED + "||" + Util.ANSI_RESET + " Attack : " + att + "\t\t"
                + "Defense\t: " + deff);
    }

    public void enemyLevel() {
        Hunter hero1 = new Hunter();
        if (hero1.getLevel() <= 5) {
            lvl = Util.randInt(1, 5);
            xhp = Util.randInt(40, 90);
            xatt = Util.randInt(10, 25);
            xdeff = Util.randInt(5, 7);
        } else if (hero1.getLevel() > 5 && hero1.getLevel() <= 10) {
            lvl = Util.randInt(5, 10);
            xhp = Util.randInt(60, 110);
            xatt = Util.randInt(15, 30);
            xdeff = Util.randInt(8, 12);
        } else if (hero1.getLevel() > 10 && hero1.getLevel() <= 15) {
            lvl = Util.randInt(10, 15);
            xhp = Util.randInt(80, 130);
            xatt = Util.randInt(20, 35);
            xdeff = Util.randInt(11, 17);
        } else if (hero1.getLevel() > 15 && hero1.getLevel() <= 20) {
            lvl = Util.randInt(15, 20);
            xhp = Util.randInt(100, 150);
            xatt = Util.randInt(25, 40);
            xdeff = Util.randInt(14, 23);
        } else if (hero1.getLevel() > 20 && hero1.getLevel() <= 25) {
            lvl = Util.randInt(20, 25);
            xhp = Util.randInt(120, 170);
            xatt = Util.randInt(30, 45);
            xdeff = Util.randInt(17, 28);
        } else if (hero1.getLevel() > 25 && hero1.getLevel() <= 30) {
            lvl = Util.randInt(25, 30);
            xhp = Util.randInt(140, 190);
            xatt = Util.randInt(40, 50);
            xdeff = Util.randInt(20, 33);
        } else if (hero1.getLevel() > 30 && hero1.getLevel() <= 35) {
            lvl = Util.randInt(30, 35);
            xhp = Util.randInt(160, 210);
            xatt = Util.randInt(45, 55);
            xdeff = Util.randInt(23, 38);
        } else if (hero1.getLevel() > 35 && hero1.getLevel() <= 40) {
            lvl = Util.randInt(35, 40);
            xhp = Util.randInt(180, 230);
            xatt = Util.randInt(50, 60);
            xdeff = Util.randInt(26, 43);
        } else if (hero1.getLevel() > 40 && hero1.getLevel() <= 45) {
            lvl = Util.randInt(40, 45);
            xhp = Util.randInt(200, 250);
            xatt = Util.randInt(55, 65);
            xdeff = Util.randInt(29, 48);
        } else if (hero1.getLevel() > 45 && hero1.getLevel() <= 50) {
            lvl = Util.randInt(45, 50);
            xhp = Util.randInt(220, 270);
            xatt = Util.randInt(60, 70);
            xdeff = Util.randInt(32, 53);
        } else if (hero1.getLevel() > 50 && hero1.getLevel() <= 55) {
            lvl = Util.randInt(50, 55);
            xhp = Util.randInt(240, 290);
            xatt = Util.randInt(65, 75);
            xdeff = Util.randInt(35, 58);
        } else if (hero1.getLevel() > 55 && hero1.getLevel() <= 60) {
            lvl = Util.randInt(55, 60);
            xhp = Util.randInt(260, 310);
            xatt = Util.randInt(70, 80);
            xdeff = Util.randInt(38, 63);
        } else if (hero1.getLevel() > 60 && hero1.getLevel() <= 65) {
            lvl = Util.randInt(60, 65);
            xhp = Util.randInt(280, 330);
            xatt = Util.randInt(75, 85);
            xdeff = Util.randInt(41, 65);
        } else if (hero1.getLevel() > 65 && hero1.getLevel() <= 70) {
            lvl = Util.randInt(65, 70);
            xhp = Util.randInt(300, 350);
            xatt = Util.randInt(80, 90);
            xdeff = Util.randInt(44, 70);
        } else if (hero1.getLevel() > 70 && hero1.getLevel() <= 75) {
            lvl = Util.randInt(70, 75);
            xhp = Util.randInt(320, 370);
            xatt = Util.randInt(85, 95);
            xdeff = Util.randInt(47, 75);
        } else if (hero1.getLevel() > 75 && hero1.getLevel() <= 80) {
            lvl = Util.randInt(75, 80);
            xhp = Util.randInt(340, 390);
            xatt = Util.randInt(90, 100);
            xdeff = Util.randInt(50, 80);
        } else if (hero1.getLevel() > 80 && hero1.getLevel() <= 85) {
            lvl = Util.randInt(80, 85);
            xhp = Util.randInt(360, 410);
            xatt = Util.randInt(95, 105);
            xdeff = Util.randInt(53, 85);
        } else if (hero1.getLevel() > 85 && hero1.getLevel() <= 90) {
            lvl = Util.randInt(85, 90);
            xhp = Util.randInt(380, 430);
            xatt = Util.randInt(100, 110);
            xdeff = Util.randInt(56, 90);
        } else if (hero1.getLevel() > 95 && hero1.getLevel() <= 100) {
            lvl = Util.randInt(95, 100);
            xhp = Util.randInt(400, 450);
            xatt = Util.randInt(105, 115);
            xdeff = Util.randInt(59, 95);
        }
        this.level = lvl;
        this.hp = xhp;
        this.att = xatt;
        this.deff = xdeff;
    }

    public void enemyStatus() {
        
        System.out.println(Util.ANSI_RED + ">----------------------"+Util.ANSI_RESET+Util.DARK_BLACK
                +"< Enemy Status >"+Util.ANSI_RESET+Util.ANSI_RED+"----------------------<" + Util.ANSI_RESET);
        System.out.println(Util.ANSI_RED + ">|" + Util.ANSI_RESET + " Enemy  : " + name);
        System.out.println(Util.ANSI_RED + ">|" + Util.ANSI_RESET + " Level  : " + level + "\t\t"
                + "HP\t: " + hp);
        System.out.println(Util.ANSI_RED + ">|" + Util.ANSI_RESET + " Attack : " + att + "\t\t"
                + "Defense\t: " + deff);
        System.out.println(Util.ANSI_RED + ">-------------------------------------------------------------<" + Util.ANSI_RESET);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setXhp(int xhp) {
        this.xhp = xhp;
    }

    public void setXatt(int xatt) {
        this.xatt = xatt;
    }

    public void setXdeff(int xdeff) {
        this.xdeff = xdeff;
    }

    public int getXhp() {
        return xhp;
    }

    public int getXatt() {
        return xatt;
    }

    public int getXdeff() {
        return xdeff;
    }

    public int getLevel() {
        return level;
    }

    public int getLvl() {
        return lvl;
    }

    public int getAtt() {
        return att;
    }

    public int getDeff() {
        return deff;
    }

    public void damageToEnemy(int damage) {
        hp = hp - (damage - getDeff());
        if (hp < 0) {
            hp = 0;
        }
        System.out.println(Util.ANSI_YELLOW + "|| " + Util.ANSI_RESET + name + " has " + hp + " HP left.");
    }

    //save and load game
    public void saveGameEnemy() {
        // open existing file
        String s5 = fileutil.openWriteFile("enemy.txt");
//        System.out.println(s5);

        // define text formatting
        String txtFormat2 = "%s,%d,%d,%d,%d%n";

        // add record 2
        String name2 = getName();
        int level2 = getLevel();
        int hp2 = getHp();
        int att2 = getAtt();
        int deff2 = getDeff();

        String s3 = fileutil.addWriteRecord(txtFormat2, name2, level2, hp2, att2, deff2);
//        System.out.println(s3);

        // close opening file
        String s6 = fileutil.closeWriteFile();
//        System.out.println(s6);
    }

    public void loadGameEnemy() {
        // read file
        // open existing file to read
        try {
            String s7 = fileutil.openReadFile("enemy.txt");
//            System.out.println(s7);

            while (fileutil.getReadScanner().hasNext()) {
                // read line per line, split line by comma delimiter

                String[] readLine = fileutil.getReadScanner().next().split(",");

                // printout per line
                String name5 = readLine[0];
                int level5 = Integer.parseInt(readLine[1]);
                int hp5 = Integer.parseInt(readLine[2]);
                int att5 = Integer.parseInt(readLine[3]);
                int deff5 = Integer.parseInt(readLine[4]);
//                System.out.printf("%s,%s,%s,%s,%s%n", name5, level5, hp5, att5, deff5);
                name = name5;
                level = level5;
                hp = hp5;
                att = att5;
                deff = deff5;
            }

            //close opening read file
            String s8 = fileutil.closeReadFile();
//            System.out.println(s8);
            loadenemystatus = true;

        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
        }
    }

    public boolean getLoadenemystatus() {
        return loadenemystatus;
    }

    public void setLoadenemystatus(boolean loadenemystatus) {
        this.loadenemystatus = loadenemystatus;
    }

    //save and load battle
    public void saveGameEnemyBattle() {
        // open existing file
        String s5 = fileutil.openWriteFile("enemybattle.txt");
//        System.out.println(s5);

        // define text formatting
        String txtFormat2 = "%s,%d,%d,%d,%d%n";

        // add record 2
        String name3 = getName();
        int level3 = getLevel();
        int hp3 = getHp();
        int att3 = getAtt();
        int deff3 = getDeff();

        String s3 = fileutil.addWriteRecord(txtFormat2, name3, level3, hp3, att3, deff3);
//        System.out.println(s3);

        // close opening file
        String s6 = fileutil.closeWriteFile();
//        System.out.println(s6);
    }

    public void loadGameEnemyBattle() {
        // read file
        // open existing file to read
        try {
            String s7 = fileutil.openReadFile("enemybattle.txt");
//            System.out.println(s7);

            while (fileutil.getReadScanner().hasNext()) {
                // read line per line, split line by comma delimiter

                String[] readLine = fileutil.getReadScanner().next().split(",");

                // printout per line
                String name5 = readLine[0];
                int level5 = Integer.parseInt(readLine[1]);
                int hp5 = Integer.parseInt(readLine[2]);
                int att5 = Integer.parseInt(readLine[3]);
                int deff5 = Integer.parseInt(readLine[4]);
//                System.out.printf("%s,%s,%s,%s,%s%n", name5, level5, hp5, att5, deff5);
                name = name5;
                level = level5;
                hp = hp5;
                att = att5;
                deff = deff5;
            }

            //close opening read file
            String s8 = fileutil.closeReadFile();
//            System.out.println(s8);
            loadenemystatus = true;

        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage());
        }
    }

}
