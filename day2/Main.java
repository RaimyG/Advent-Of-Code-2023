/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Integer resultPartOne = partOne();
        System.out.println(resultPartOne);
    }

    private static int[][] getData() {
        String[] puzzleInputRows = puzzleInput.split("\n");
        int[][] cubes = new int[100][3]; // [ {nbRed, nbGreen, nbBlue}, ...]
        int index = 0, nbRedInGame, nbGreenInGame, nbBlueInGame;

        for (String gameRow : puzzleInputRows) {
            String[] game = gameRow.split(":");

            String gameId = game[0].split(" ")[1]; // Retrieve the part "Game XX" and extract the ID
            String[] gameDraws = game[1].split(";");

            // Reset colors counter for new Game
            nbRedInGame = 0;
            nbGreenInGame = 0;
            nbBlueInGame = 0;

            for (String gameDraw : gameDraws) {
                String[] cubesInDraw = gameDraw.split(", ");
                for (String cubeInDraw : cubesInDraw) {

                    String[] cubeInfo = cubeInDraw.trim().split(" ");

                    // cubeInfo[0] => number
                    // cubeInfo[1] => color name
                    if (cubeInfo[1].equals("red")) {
                        if (cubes[index][0] < Integer.parseInt(cubeInfo[0])) {
                            nbRedInGame = Integer.parseInt(cubeInfo[0]);
                        }
                    }
                    if (cubeInfo[1].equals("green")) {
                        if (cubes[index][1] < Integer.parseInt(cubeInfo[0])) {
                            nbGreenInGame = Integer.parseInt(cubeInfo[0]);
                        }
                    }
                    if (cubeInfo[1].equals("blue")) {
                        if (cubes[index][2] < Integer.parseInt(cubeInfo[0])) {
                            nbBlueInGame = Integer.parseInt(cubeInfo[0]);
                        }
                    }
                }
            }

            cubes[index][0] = nbRedInGame;
            cubes[index][1] = nbGreenInGame;
            cubes[index][2] = nbBlueInGame;

            index++;
        }

        return cubes;
    }

    private static int partOne() {
        int[][] allGames = getData();
        int gameId = 1;
        int total = 0;
        for (int[] game : allGames) {

            System.out.println("############## GAME " + gameId + " ##################");
            if (game[0] <= 12 && game[1] <= 13 && game[2] <= 14) {
                System.out.println("OUI");
            } else {
                System.out.println("NON");
            }
            // System.out.println("RED : " + game[0]);
            // System.out.println("GREEN : " + game[1]);
            // System.out.println("BLUE : " + game[2]);
            System.out.println("##########################################");

            if (game[0] <= 12 && game[1] <= 13 && game[2] <= 14) {
                total += gameId;
            }

            gameId++;
        }
        return total;
    }

    private static String puzzleInput = "Game 1: 1 green, 2 blue; 13 red, 2 blue, 3 green; 4 green, 14 red\n" + //
            "Game 2: 2 blue, 11 green; 4 blue, 12 red, 4 green; 7 red, 1 blue, 9 green; 10 green, 12 red, 6 blue\n" + //
            "Game 3: 1 blue, 12 green, 2 red; 9 red, 16 green; 1 red, 10 green, 1 blue; 1 red, 14 green\n" + //
            "Game 4: 8 green, 18 blue; 4 green, 14 blue, 2 red; 3 blue, 5 green, 11 red\n" + //
            "Game 5: 7 red, 15 blue, 1 green; 13 blue; 18 red, 2 green, 9 blue; 19 blue, 5 green, 10 red; 9 green, 2 blue, 7 red\n"
            + //
            "Game 6: 1 red, 8 blue, 2 green; 1 blue, 3 red, 5 green; 2 green, 3 red, 2 blue; 1 blue, 4 green\n" + //
            "Game 7: 4 red, 6 green, 1 blue; 3 blue, 9 green, 5 red; 5 blue, 5 green, 4 red; 6 green, 5 blue, 5 red; 13 red; 4 red, 2 blue, 9 green\n"
            + //
            "Game 8: 7 blue, 14 green, 5 red; 1 green, 7 blue, 11 red; 6 blue, 16 red, 4 green; 8 red, 11 green, 7 blue; 6 blue, 18 red, 9 green\n"
            + //
            "Game 9: 3 blue, 1 green, 6 red; 1 red, 1 blue, 1 green; 6 red, 2 blue, 1 green\n" + //
            "Game 10: 6 red, 11 blue, 12 green; 1 blue, 2 red, 3 green; 14 green, 6 red, 7 blue; 6 red, 10 blue, 9 green; 6 blue, 2 red\n"
            + //
            "Game 11: 5 blue, 2 red, 18 green; 2 blue, 13 green; 8 blue, 15 green, 2 red\n" + //
            "Game 12: 5 red, 4 blue; 1 blue, 8 green, 8 red; 15 green, 5 red, 4 blue\n" + //
            "Game 13: 12 blue, 1 red, 6 green; 9 red, 6 blue, 12 green; 3 red, 11 green, 6 blue; 8 red, 4 green, 10 blue; 3 green, 7 blue\n"
            + //
            "Game 14: 9 red, 5 green, 1 blue; 1 red, 3 blue; 10 green, 7 red; 5 blue, 8 green, 10 red\n" + //
            "Game 15: 3 blue, 9 red, 14 green; 15 green, 2 blue, 6 red; 7 green, 1 red, 5 blue\n" + //
            "Game 16: 7 green, 4 blue, 6 red; 6 green, 4 blue, 8 red; 5 red, 2 blue, 10 green; 4 blue, 4 red, 15 green; 9 red, 15 green, 6 blue; 7 green, 5 blue, 2 red\n"
            + //
            "Game 17: 8 red, 6 green, 2 blue; 4 green, 1 blue, 17 red; 1 green, 11 red, 1 blue\n" + //
            "Game 18: 13 blue, 1 green, 3 red; 2 red, 2 green; 11 red, 1 green, 7 blue; 2 green, 7 blue, 2 red\n" + //
            "Game 19: 2 green, 13 red, 2 blue; 1 green, 6 blue, 4 red; 1 green, 2 blue, 15 red\n" + //
            "Game 20: 10 red, 11 blue, 8 green; 6 red, 13 blue, 2 green; 6 blue, 8 green, 3 red; 10 red, 2 blue, 8 green; 2 red, 3 blue, 7 green; 3 red\n"
            + //
            "Game 21: 2 blue, 10 red; 5 green, 3 red; 5 green, 4 red, 4 blue; 6 blue, 9 red, 10 green\n" + //
            "Game 22: 5 red, 1 green; 5 red; 4 red, 1 blue; 1 blue, 10 red\n" + //
            "Game 23: 2 red, 11 blue, 4 green; 4 blue; 1 blue, 6 green, 4 red; 3 green, 4 blue, 2 red\n" + //
            "Game 24: 4 green; 12 green, 4 blue, 1 red; 11 green, 1 blue, 2 red\n" + //
            "Game 25: 10 red, 1 blue, 3 green; 3 green, 6 blue, 6 red; 2 green, 9 red, 2 blue; 1 blue, 3 green, 7 red; 6 blue, 4 green; 1 red\n"
            + //
            "Game 26: 4 red, 11 green, 5 blue; 2 blue, 11 red, 9 green; 11 green, 3 red; 14 green, 13 red, 5 blue; 10 red, 5 blue, 9 green; 12 red, 4 blue, 6 green\n"
            + //
            "Game 27: 8 red, 9 blue, 7 green; 14 red, 15 blue, 2 green; 7 green, 13 blue, 9 red; 8 green, 4 blue, 1 red\n"
            + //
            "Game 28: 4 blue, 4 green, 3 red; 4 green, 9 red, 4 blue; 13 red, 10 blue, 4 green\n" + //
            "Game 29: 7 red; 1 blue, 1 green; 3 red, 1 green, 1 blue; 2 blue; 17 red, 2 blue, 1 green; 6 red, 1 green, 2 blue\n"
            + //
            "Game 30: 10 green, 4 red, 4 blue; 5 red, 6 blue, 9 green; 2 red, 3 green, 4 blue; 1 blue, 9 green, 1 red; 1 red\n"
            + //
            "Game 31: 6 red, 3 green; 1 blue, 3 green, 9 red; 2 blue, 11 red; 13 red, 2 blue, 3 green; 5 green, 3 blue\n"
            + //
            "Game 32: 2 red, 1 blue, 1 green; 3 green, 1 blue; 1 red, 6 green; 3 red, 3 green; 1 blue; 12 green, 3 red, 1 blue\n"
            + //
            "Game 33: 17 blue, 14 green, 7 red; 5 red, 9 green, 16 blue; 8 green, 3 blue, 3 red; 10 green, 12 blue, 1 red\n"
            + //
            "Game 34: 2 red, 1 green, 9 blue; 14 blue, 2 green, 9 red; 10 blue, 2 green, 16 red; 2 green, 5 red, 14 blue; 5 blue, 12 red, 2 green; 8 blue, 15 red, 3 green\n"
            + //
            "Game 35: 14 green, 4 red; 16 green, 4 red; 4 red, 3 blue, 3 green; 5 green, 4 red, 4 blue; 3 red, 1 blue, 8 green\n"
            + //
            "Game 36: 1 blue, 8 red, 4 green; 2 green, 15 blue, 4 red; 13 blue, 5 red, 8 green\n" + //
            "Game 37: 2 red, 8 green, 7 blue; 9 green, 20 red, 3 blue; 3 blue, 1 green, 2 red; 9 red, 1 blue, 4 green; 6 green, 2 blue, 20 red\n"
            + //
            "Game 38: 8 red, 2 blue, 2 green; 7 green, 4 red; 4 red, 10 green, 2 blue\n" + //
            "Game 39: 9 green, 11 red, 6 blue; 6 blue, 2 green, 19 red; 2 red, 3 blue, 2 green; 4 green, 2 blue, 13 red; 19 red, 7 green, 1 blue\n"
            + //
            "Game 40: 7 blue, 2 green, 11 red; 19 red, 4 green, 2 blue; 1 green, 10 red, 5 blue; 2 red, 1 green, 2 blue\n"
            + //
            "Game 41: 1 red, 1 blue, 13 green; 13 green, 11 red, 5 blue; 19 green, 3 blue; 18 green, 1 red\n" + //
            "Game 42: 1 blue, 2 green, 7 red; 13 green, 5 red, 7 blue; 6 red, 13 green, 9 blue; 12 red, 17 blue, 13 green; 9 red, 16 blue, 5 green; 11 red, 4 green\n"
            + //
            "Game 43: 3 blue, 4 red; 6 red, 5 blue; 7 blue, 1 green, 5 red; 3 blue, 10 red\n" + //
            "Game 44: 10 green, 10 blue; 2 blue, 10 red, 10 green; 2 green, 5 red, 4 blue; 8 red, 2 green, 2 blue; 14 red, 3 blue, 10 green; 14 red, 5 green, 3 blue\n"
            + //
            "Game 45: 9 green, 2 red, 2 blue; 2 blue, 2 red, 7 green; 9 blue, 6 green\n" + //
            "Game 46: 2 blue, 1 green; 1 blue, 1 red, 1 green; 1 blue; 1 blue, 1 green\n" + //
            "Game 47: 4 green, 10 red, 14 blue; 19 red, 3 blue, 1 green; 4 green, 14 blue, 15 red; 9 blue, 17 red; 3 green, 12 blue, 7 red; 1 red, 11 blue, 4 green\n"
            + //
            "Game 48: 9 red, 2 green, 1 blue; 7 red, 3 blue; 8 red, 1 green; 1 blue, 3 red\n" + //
            "Game 49: 2 red, 3 green, 13 blue; 7 red, 15 blue, 3 green; 15 blue, 7 red; 11 blue, 5 red, 3 green\n" + //
            "Game 50: 4 red, 4 green, 2 blue; 2 green, 3 red; 2 green, 3 red, 11 blue; 3 green, 2 red\n" + //
            "Game 51: 4 blue, 17 green; 3 blue, 17 green, 1 red; 6 green, 8 blue\n" + //
            "Game 52: 14 blue, 3 red; 11 green, 6 red, 9 blue; 6 blue, 10 red; 1 red, 1 green, 4 blue; 9 blue, 6 green; 3 red, 2 blue, 8 green\n"
            + //
            "Game 53: 1 blue, 9 red, 9 green; 11 green, 1 red, 7 blue; 11 green, 9 red, 7 blue; 12 green, 15 red, 7 blue; 7 blue, 12 red, 1 green; 6 blue, 2 green, 4 red\n"
            + //
            "Game 54: 7 blue, 2 red, 4 green; 2 red, 16 blue, 8 green; 15 blue, 7 green; 5 blue, 3 red, 2 green; 9 green, 15 blue; 1 green, 14 blue\n"
            + //
            "Game 55: 5 red, 10 blue, 2 green; 5 blue, 5 red, 2 green; 6 red, 1 green; 7 red, 8 blue, 1 green; 1 green, 13 blue\n"
            + //
            "Game 56: 14 blue, 11 green, 3 red; 10 blue, 7 green, 2 red; 2 red, 13 green, 1 blue\n" + //
            "Game 57: 10 blue, 6 red; 10 red, 4 blue, 6 green; 2 green, 16 blue; 6 blue, 11 red, 7 green\n" + //
            "Game 58: 3 red, 2 blue; 9 green, 12 blue; 1 red, 1 green, 5 blue; 1 blue, 2 green\n" + //
            "Game 59: 6 red, 9 green, 2 blue; 6 green, 6 red, 7 blue; 2 green, 7 blue, 9 red; 1 green, 10 blue; 1 green, 3 blue, 1 red; 10 green, 1 red, 3 blue\n"
            + //
            "Game 60: 13 green, 5 red, 9 blue; 3 blue, 12 green, 9 red; 4 blue, 17 green, 9 red; 12 green, 2 red; 6 red, 3 green, 8 blue; 13 green, 12 red\n"
            + //
            "Game 61: 4 green, 15 red; 5 green, 15 red; 1 blue, 7 green, 12 red; 8 green, 3 blue, 4 red; 11 green, 11 red, 3 blue; 7 red, 12 green, 2 blue\n"
            + //
            "Game 62: 3 red; 2 green, 8 red; 10 red, 8 blue; 1 blue, 4 red, 2 green; 2 green, 13 red; 6 red, 9 blue\n" + //
            "Game 63: 4 green, 12 blue, 5 red; 5 blue, 5 green, 5 red; 3 blue, 17 green; 1 red, 1 blue, 17 green; 10 green, 4 red, 15 blue; 15 blue, 4 green\n"
            + //
            "Game 64: 12 red, 9 blue, 4 green; 1 green, 1 red, 8 blue; 10 green, 11 red, 1 blue; 2 red, 10 blue\n" + //
            "Game 65: 1 red, 3 green, 11 blue; 2 red, 6 green, 3 blue; 1 red, 7 green, 1 blue\n" + //
            "Game 66: 2 green, 2 red, 4 blue; 19 red, 11 blue, 4 green; 6 blue, 2 green, 13 red; 16 blue, 4 green\n" + //
            "Game 67: 1 blue, 5 red, 1 green; 1 green, 1 red, 1 blue; 2 green, 1 blue, 19 red\n" + //
            "Game 68: 3 green, 1 red; 1 red, 3 blue; 3 blue, 2 red, 10 green; 4 green\n" + //
            "Game 69: 5 green, 11 blue, 5 red; 13 green, 19 red, 8 blue; 19 red, 2 green, 11 blue\n" + //
            "Game 70: 7 blue, 9 green; 1 red, 11 blue, 2 green; 6 blue, 10 green, 1 red\n" + //
            "Game 71: 2 red, 2 green, 9 blue; 1 green, 20 blue, 1 red; 17 blue, 3 green, 2 red; 3 green, 13 blue, 2 red; 16 blue, 3 green; 11 blue\n"
            + //
            "Game 72: 6 red, 4 green, 10 blue; 6 red, 7 blue; 1 blue, 8 green; 3 green, 6 red, 1 blue\n" + //
            "Game 73: 2 green, 12 blue, 2 red; 6 red, 6 blue, 3 green; 8 red, 3 green, 1 blue; 3 green, 5 red, 10 blue\n"
            + //
            "Game 74: 1 red, 15 green; 3 blue, 5 green, 6 red; 7 red, 5 green; 12 red, 12 green\n" + //
            "Game 75: 14 blue, 2 green, 8 red; 13 blue, 6 green, 4 red; 4 green, 6 red, 1 blue\n" + //
            "Game 76: 12 red, 5 blue, 1 green; 6 blue, 11 red; 2 red, 7 blue; 6 blue, 16 red\n" + //
            "Game 77: 7 red, 2 green, 1 blue; 6 blue; 3 red, 1 green, 10 blue; 5 blue, 2 green, 1 red\n" + //
            "Game 78: 9 blue, 3 green, 14 red; 16 red, 15 blue; 16 red, 9 green, 10 blue; 2 red, 8 blue, 3 green\n" + //
            "Game 79: 7 green, 5 blue, 2 red; 5 red, 5 blue, 1 green; 2 red, 3 blue, 10 green; 5 green, 1 blue, 3 red; 5 blue, 3 red, 7 green\n"
            + //
            "Game 80: 7 red, 6 blue; 6 red, 6 blue; 7 blue, 2 green; 3 red, 9 blue\n" + //
            "Game 81: 8 green, 9 red, 1 blue; 9 red, 7 green; 1 green, 5 red; 2 green, 1 red; 1 blue, 14 red, 6 green; 1 blue, 11 green, 6 red\n"
            + //
            "Game 82: 4 blue, 14 red, 1 green; 2 red, 4 green, 2 blue; 7 green, 4 blue, 13 red; 2 red, 1 green, 6 blue\n"
            + //
            "Game 83: 9 red, 2 blue, 2 green; 6 green, 6 red; 9 red, 3 blue, 6 green\n" + //
            "Game 84: 9 green, 1 red, 1 blue; 4 red, 15 green; 7 green, 1 blue, 12 red; 1 blue, 11 red, 14 green; 2 green, 11 red\n"
            + //
            "Game 85: 13 green; 11 green; 15 blue, 10 green; 8 blue, 6 green; 11 green, 1 red, 3 blue; 13 green\n" + //
            "Game 86: 13 green, 1 blue, 4 red; 1 green, 5 red; 1 blue, 9 green, 5 red\n" + //
            "Game 87: 4 green, 5 red, 2 blue; 4 green; 8 green, 2 blue, 1 red; 4 blue, 8 green, 1 red; 5 red, 9 blue, 8 green; 7 blue\n"
            + //
            "Game 88: 5 green, 1 blue, 3 red; 2 blue, 2 red, 3 green; 3 green; 2 blue, 1 red, 6 green\n" + //
            "Game 89: 13 blue, 6 red, 15 green; 5 green, 14 blue, 9 red; 3 green, 15 blue, 5 red; 13 red, 13 green; 18 red, 4 green, 19 blue; 10 green, 10 red, 18 blue\n"
            + //
            "Game 90: 1 red, 1 green; 1 blue, 2 green, 1 red; 5 red, 2 blue\n" + //
            "Game 91: 9 blue; 6 green, 12 blue, 2 red; 3 red, 1 green, 8 blue; 7 green, 2 red, 8 blue\n" + //
            "Game 92: 15 red, 7 green, 1 blue; 19 green, 12 red, 1 blue; 7 red, 16 green; 8 green, 1 blue, 14 red; 8 red, 1 blue, 9 green\n"
            + //
            "Game 93: 11 red, 4 green; 7 green, 8 red; 4 blue, 6 green; 8 red, 6 green, 1 blue; 6 green; 1 red, 1 green, 4 blue\n"
            + //
            "Game 94: 15 green; 1 red, 4 blue, 4 green; 1 red, 1 blue; 4 red, 1 green, 5 blue; 18 green, 3 red, 3 blue; 1 red\n"
            + //
            "Game 95: 1 blue, 3 green, 10 red; 1 blue, 6 green; 15 green, 2 red, 3 blue; 2 blue, 8 red, 11 green; 13 green, 10 red; 5 red\n"
            + //
            "Game 96: 8 green; 5 blue, 2 red, 4 green; 3 green, 4 red\n" + //
            "Game 97: 5 red, 4 blue; 1 blue, 2 red, 9 green; 10 green, 3 red; 4 green, 3 blue, 4 red; 5 red, 4 green, 3 blue\n"
            + //
            "Game 98: 3 green, 3 blue, 2 red; 2 blue, 2 red, 1 green; 3 green, 5 blue\n" + //
            "Game 99: 11 green, 4 red, 12 blue; 9 red, 4 blue; 20 green, 6 blue\n" + //
            "Game 100: 12 red, 9 green; 12 red; 9 red, 3 green; 8 red, 4 blue, 4 green; 8 blue, 11 red, 2 green\n" + //
            "";
}
