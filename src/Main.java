
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    String castle = "\uD83D\uDCCD";
    int step = 0;

    System.out.println("Привет! Ты готов начать игру? (ДА или НЕТ)");

    String answer = sc.nextLine().trim();

    if (answer.equalsIgnoreCase("НЕТ")) {
        System.out.println("Жаль, приходи еще!");
        sc.close();
        return;
    }

    if (!answer.equalsIgnoreCase("ДА")) {
        System.out.println("Данные введены некорректно!");
        sc.close();
        return;
    }

    System.out.println("Выбери сложность игры (от 1 до 5)");

    int difficulty = sc.nextInt();

    if (difficulty < 1 || difficulty > 5) {
        System.out.println("Некорректная сложность!");
        sc.close();
        return;
    }

    int sizeBoard;

    switch (difficulty) {
        case 1: sizeBoard = 5; break;
        case 2: sizeBoard = 8; break;
        case 3: sizeBoard = 11; break;
        case 4: sizeBoard = 14; break;
        case 5: sizeBoard = 20; break;
        default: sizeBoard = 5;
    }

    System.out.println("РАЗМЕР ДОСКИ: " + sizeBoard + "x" + sizeBoard);

    System.out.println("Заказ принят. Обратно пути нет.");
    System.out.println("Район доставки находится под контролем противника.");

    Person person = new Person(sizeBoard);

    int castleX = 1 + random.nextInt(sizeBoard);
    int castleY = 1;

    String[][] board = new String[sizeBoard][sizeBoard];

    for (int y = 0; y < sizeBoard; y++) {
        for (int x = 0; x < sizeBoard; x++) {
            board[y][x] = "  ";
        }
    }

        Monster.setScanner(sc);


        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        Monster[] monsters = new Monster[countMonster];

        int count = 0;
        int monsterCount = Math.min(sizeBoard * difficulty, countMonster);

        while (count < monsterCount) {

            Monster monster;

            if (random.nextBoolean()) {
                monster = new Monster(sizeBoard);
            } else {
                monster = new BigMonster(sizeBoard);
            }

            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (board[row][column].equals("  ")
                    && !(monster.getY() == castleY
                    && monster.getX() == castleX)) {

                board[row][column] = monster.getImage() + " ";
                monsters[count] = monster;
                count++;
            }
        }

        board[castleY - 1][castleX - 1] = castle;

        System.out.println("Внимание! В районе замечены военные патрули.");
        System.out.println("Нужно добраться до точки доставки.");

        switch (answer.toUpperCase()) {

            case "ДА":

                while (true) {

                    board[person.getY() - 1][person.getX() - 1]
                            = person.getImage();

                    outputBoard(board, person.getLive());

                    System.out.println("Введите новые координаты персонажа"
                            + "\nХод возможен только по вертикали и горизонтали на одну клетку"
                            + "\nКоординаты персонажа - (x: "
                            + person.getX() + ", y: " + person.getY() + ")");

                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    if (x < 1 || x > sizeBoard
                            || y < 1 || y > sizeBoard) {

                        System.out.println("Координаты находятся за пределами поля!");
                        continue;
                    }

                    if (person.isMoveCorrect(x, y)) {

                        if (board[y - 1][x - 1].equals(castle)) {

                            System.out.println("ДОСТАВКА ВЫПОЛНЕНА!");
                            System.out.println("Клиент даже не вышел встретить курьера.");
                            System.out.println("Поздравляем! Ты выжил.");
                            break;

                        } else if (board[y - 1][x - 1].equals("  ")) {

                            board[person.getY() - 1][person.getX() - 1] = "  ";

                            person.move(x, y);

                            step++;

                            System.out.println("Ход корректный; Новые координаты: "
                                    + person.getX() + ", " + person.getY()
                                    + "\nХод номер: " + step);

                        } else {

                            for (int i = 0; i < monsters.length; i++) {

                                Monster monster = monsters[i];

                                if (monster != null &&
                                        monster.conflicktPersonIMonster(x, y)) {
                                    
                                    if (monster instanceof BigMonster) {
                                        System.out.println("Осторожно! На пути гвардеец!");
                                    } else {
                                        System.out.println("Впереди вражеский патруль!");
                                    }

                                    if (monster.taskMonster(difficulty)) {

                                        board[person.getY() - 1][person.getX() - 1] = "  ";

                                        person.move(x, y);

                                        monsters[i] = null;

                                        System.out.println("Противник устранён. Путь свободен.");

                                        step++;

                                    } else {

                                        person.downLive();

                                        System.out.println("Доставка становится всё рискованнее...");

                                        System.out.println("Ты потерял одну жизнь!");
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

        sc.close();
    }
    static void outputBoard(String[][] board, int live) {

        StringBuilder wall = new StringBuilder("+");

        for (int i = 0; i < board[0].length; i++) {
            wall.append("----+");
        }

        String wallLine = wall.toString();

        for (String[] row : board) {

            System.out.println(wallLine);

            for (String cell : row) {
                System.out.print("| " + cell + " ");
            }

            System.out.println("|");
        }

        System.out.println(wallLine);
        System.out.println("Количество жизней:\t" + live);
    }
