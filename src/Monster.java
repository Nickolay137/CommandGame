
import java.util.Random;
import java.util.Scanner;

public class Monster {

    private String image = "\uD83E\uDE96";
    private int x, y;

    protected static Scanner scanner;

    Monster(int sizeBoard) {
        Random random = new Random();

        x = 1 + random.nextInt(sizeBoard);
        y = 1 + random.nextInt(sizeBoard - 1);
    }

    public static void setScanner(Scanner input) {
        scanner = input;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean conflicktPersonIMonster(int personX, int personY) {
        return personX == x && personY == y;
    }

    public boolean taskMonster(int sloznostIgri) {

        Random random = new Random();

        int maxNumber = (int) Math.pow(10, sloznostIgri);

        int a = random.nextInt(maxNumber);
        int b = random.nextInt(maxNumber);

        int trueAnswer = a + b;

        System.out.println("Реши пример: " + a + " + " + b);

        int ans = scanner.nextInt();

        if (ans == trueAnswer) {
            System.out.println("Ты победил монстра!");
            return true;
        } else {
            System.out.println("Неправильно! Правильный ответ: "
                    + trueAnswer);
            return false;
        }
    }
}
