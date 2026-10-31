import java.util.Random;
import java.util.Scanner;

public class Main {
    void main() {
        String castle = "\uD83C\uDFF0";
        int step = 0;
        int sizeBoard = 5;

        Person person = new Person(sizeBoard);


        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        int castleY = 1;

        String[][] board = new String[sizeBoard][sizeBoard];

        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("Привет! Ты готов начать игру? (Напиши: ДА или НЕТ)");

        String answer = sc.nextLine();

        System.out.println("Ваш ответ:\t" + answer);

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        Monster[] monsters = new Monster[countMonster];
        int count = 0;
        int monsterCount = 0;
        System.out.println("Выбери сложность игры (от 1 до 5)");
        int difficulty = sc.nextInt();
        System.out.println("Выбранная сложность:\t" + difficulty);

        switch (difficulty) {
            case (1):
                monsterCount += sizeBoard * difficulty;
                break;
            case (2):
                monsterCount += sizeBoard * difficulty;
                break;
            case (3):
                monsterCount += sizeBoard * difficulty;
                break;
            case (4):
                monsterCount += sizeBoard * difficulty;
                break;
            case (5):
                monsterCount += sizeBoard * difficulty;
                break;
        }

        while (monsterCount > 0) {
            Monster monster;
            if (random.nextBoolean()) {
                monster = new Monster(sizeBoard);
                monsterCount--;
            } else {
                monster = new BigMonster(sizeBoard);
            }


            int row = monster.getX() - 1;
            int column = monster.getY() - 1;

            if (board[row][column].equals("  ")) {
                board[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
                monsterCount--;
            }
        }

        board[castleY - 1][castleX - 1] = castle;


        switch (answer) {
            case "ДА":

                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();

                    outputBoard(board, person.getLive());


                    System.out.println("Введите новые координаты персонажа (ход возможен только по вертикали и горизонтали на одну клетку" +
                            "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + ")");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    System.out.println(x + " " + y);

                    if (person.isMoveCorrect(x, y)) {
                        if (board[y - 1][x - 1].equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;

                            System.out.println("Ход корректный; Новые координаты: " +
                                    person.getX() + ", " + person.getY() + "\nХод номер: " + step);
                        } else if (board[y - 1][x - 1].equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else {
                            for (Monster monster: monsters) {
                                if (monster.conflicktPersonIMonster(x, y)) {
                                    if (monster.taskMonster(difficulty)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                        step++;
                                    } else {
                                        person.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Некорректный ход");
                    }

                    if (person.getLive() <= 0) {
                        System.out.println("Ты проиграл(");
                        break;
                    }
                }
                break;

            case "НЕТ":
                System.out.println("Жаль, приходи еще!");
                break;

            default:
                System.out.println("Данные введены некорректно");
        }
    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";

        for (String[] row : board) {
            System.out.println(wall);

            for (String cell : row) {
                System.out.print(leftBlock);
                System.out.print(cell);
            }

            System.out.println(rightBlock);
        }

        System.out.println(wall);

        System.out.println("Количество жизней:\t" + live);

    }
}
