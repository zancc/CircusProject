package com.company;

public class GameBoard {

    public static final String RESET = "\u001B[0m"; //ANSI code for colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[1;33m"; //yellow
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m"; //purple
    public static final String CYAN = "\u001B[1;36m";
    public static final String WHITE = "\u001B[37m";

    public static void printBoard() {

        //inside the each cell - player1.symbol (" " or existing symbol) and same for player2.
        //symbols could be stored in the ArrayList or Map


//        System.out.println(RED + "This text is red!" + RESET);

        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("| 120     | "+bad(119)+"     | 118     | "+bad(117)+"     | 116     | 115     | 114     | 113     | "+bad(112)+"     | 111     |");
        System.out.println("| "+pic(120)+" | "+pic(119)+" | "
                +pic(118)+" | "+pic(117)+" | "+pic(116)+" | "+pic(115)+
                " | "+pic(114)+" | "+pic(113)+" | "+pic(112)+" | "+pic(111)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 101     | "+bad(102)+"     | 103     | 104     | 105     | 106     | "+bad(107)+"     | 108     | 109     | 110     |");
        System.out.println("| "+pic(101)+" | "+pic(102)+" | "
                +pic(103)+" | "+pic(104)+" | "+pic(105)+" | "+pic(106)+
                " | "+pic(107)+" | "+pic(108)+" | "+pic(109)+" | "+pic(110)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 100     | 99      | 98      | 97      | "+good(96)+"      | 95      | 94      | 93      | "+good(92)+"      | 91      |");
        System.out.println("| "+pic(100)+" | "+pic(99)+" | "
                +pic(98)+" | "+pic(97)+" | "+pic(96)+" | "+pic(95)+
                " | "+pic(94)+" | "+pic(93)+" | "+pic(92)+" | "+pic(91)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 81      | 82      | 83      | 84      | 85      | 86      | "+bad(87)+"      | 88      | 89      | 90      |");
        System.out.println("| "+pic(81)+" | "+pic(82)+" | "
                +pic(83)+" | "+pic(84)+" | "+pic(85)+" | "+pic(86)+
                " | "+pic(87)+" | "+pic(88)+" | "+pic(89)+" | "+pic(90)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 80      | 79      | 78      | 77      | 76      | 75      | 74      | 73      | "+good(72)+"      | "+bad(71)+"      |");
        System.out.println("| "+pic(80)+" | "+pic(79)+" | "
                +pic(78)+" | "+pic(77)+" | "+pic(76)+" | "+pic(75)+
                " | "+pic(74)+" | "+pic(73)+" | "+pic(72)+" | "+pic(71)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 61      | 62      | 63      | 64      | "+good(65)+"      | 66      | 67      | 68      | 69      | 70      |");
        System.out.println("| "+pic(61)+" | "+pic(62)+" | "
                +pic(63)+" | "+pic(64)+" | "+pic(65)+" | "+pic(66)+
                " | "+pic(67)+" | "+pic(68)+" | "+pic(69)+" | "+pic(70)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 60      | "+good(59)+"      | 58      | "+good(57)+"      | 56      | 55      | 54      | "+bad(53)+"      | "+good(52)+"      | 51      |");
        System.out.println("| "+pic(60)+" | "+pic(59)+" | "
                +pic(58)+" | "+pic(57)+" | "+pic(56)+" | "+pic(55)+
                " | "+pic(54)+" | "+pic(53)+" | "+pic(52)+" | "+pic(51)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 41      | 42      | 43      | 44      | 45      | 46      | 47      | 48      | 49      | "+bad(50)+"      |");
        System.out.println("| "+pic(41)+" | "+pic(42)+" | "
                +pic(43)+" | "+pic(44)+" | "+pic(45)+" | "+pic(46)+
                " | "+pic(47)+" | "+pic(48)+" | "+pic(49)+" | "+pic(50)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| "+good(40)+"      | 39      | 38      | 37      | "+good(36)+"      | 35      | "+good(34)+"      | 33      | 32      | 31      |");
        System.out.println("| "+pic(40)+" | "+pic(39)+" | "
                +pic(38)+" | "+pic(37)+" | "+pic(36)+" | "+pic(35)+
                " | "+pic(34)+" | "+pic(33)+" | "+pic(32)+" | "+pic(31)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 21      | 22      | 23      | 24      | "+bad(25)+"      | 26      | 27      | 28      | 29      | 30      |");
        System.out.println("| "+pic(21)+" | "+pic(22)+" | "
                +pic(23)+" | "+pic(24)+" | "+pic(25)+" | "+pic(26)+
                " | "+pic(27)+" | "+pic(28)+" | "+pic(29)+" | "+pic(30)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("| 20      | 19      | 18      |  17     | "+bad(16)+"      | 15      | "+good(14)+"      | 13      | 12      | 11      |");
        System.out.println("| "+pic(20)+" | "+pic(19)+" | "
                +pic(18)+" | "+pic(17)+" | "+pic(16)+" | "+pic(15)+
                " | "+pic(14)+" | "+pic(13)+" | "+pic(12)+" | "+pic(11)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");
        System.out.println("|  1      |  2      |  "+good(3)+"      |  4      |  5      |  6      |  7      |  8      |  "+good(9)+"      | 10      |");
        System.out.println("| "+pic(1)+" | "+pic(2)+" | "
                +pic(3)+" | "+pic(4)+" | "+pic(5)+" | "+pic(6)+
                " | "+pic(7)+" | "+pic(8)+" | "+pic(9)+" | "+pic(10)+" |");
        System.out.println("|_________|_________|_________|_________|_________|_________|_________|_________|_________|_________|");


    }

    private static String printSymbol(int n) {
        if (Main.numberOfPlayer == 1) {
            return (Main.players.get(0).getFieldPrint().get(n) + "      ");
        } else if (Main.numberOfPlayer == 2) {
            return (Main.players.get(0).getFieldPrint().get(n) +
                    " " + Main.players.get(1).getFieldPrint().get(n) + "    ");
        } else if (Main.numberOfPlayer == 3) {
            return (Main.players.get(0).getFieldPrint().get(n) +
                    " " + Main.players.get(1).getFieldPrint().get(n) +
                    " " + Main.players.get(2).getFieldPrint().get(n) + "  ");
        } else if (Main.numberOfPlayer ==4) {
            return (Main.players.get(0).getFieldPrint().get(n) +
                    " " + Main.players.get(1).getFieldPrint().get(n) +
                    " " + Main.players.get(2).getFieldPrint().get(n) +
                    " " + Main.players.get(3).getFieldPrint().get(n));
        }
        return null;
    }

    private static String pic(int n) { //print in colors
        return CYAN+printSymbol(n)+RESET;
    }

    public static String pic(String COLOR, char s) { //print in colors
        return COLOR+s+RESET;
    }

    public static String pic(String COLOR, String s) { //print in colors
        return COLOR+s+RESET;
    }


    private static String bad(int fieldNumber) {
        return RED+fieldNumber+RESET;
    }

    private static String good(int fieldNumber) {
        return GREEN+fieldNumber+RESET;
    }
}
