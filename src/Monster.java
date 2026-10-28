import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83E\uDDDF";
    private int x, y;

    Monster(int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard);
        y = 1 + random.nextInt(sizeBoard - 1);
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

    Random random = new Random();

    public boolean conflicktPersonIMonster(int personX, int personY) {
        return personX == x && personY == y;
    }

    public boolean taskMonster(int sloznostIgri) {
        if (sloznostIgri == 1) {
            int a = random.nextInt(10 ^ sloznostIgri);
            int b = random.nextInt(10 ^ sloznostIgri);
            int trueansver = a + b;

            System.out.println("Зеши пример: " + a + "+" + b);
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (ans == trueansver) {
                System.out.println("Ты ПоБЕдИл!!!");
                return true;
            } else {
                System.out.println("Ты ПРоИГраЛ(((");
                return false;
            }
        } else if (sloznostIgri == 2) {
            int a = random.nextInt(10 ^ (sloznostIgri * 2));
            int b = random.nextInt(10 ^ (sloznostIgri * 2));
            int trueansver = a + b;

            System.out.println("Зеши пример: " + a + "+" + b);
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (ans == trueansver) {
                System.out.println("Ты ПоБЕдИл!!!");
                return true;
            } else {
                System.out.println("Ты ПРоИГраЛ(((");
                return false;
            }

        } else if (sloznostIgri == 3) {
            int a = random.nextInt(10 ^ (sloznostIgri * 3));
            int b = random.nextInt(10 ^ (sloznostIgri * 3));
            int trueansver = a + b;

            System.out.println("Зеши пример: " + a + "+" + b);
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (ans == trueansver) {
                System.out.println("Ты ПоБЕдИл!!!");
                return true;
            } else {
                System.out.println("Ты ПРоИГраЛ(((");
                return false;
            }
        } else if (sloznostIgri == 4) {
            int a = random.nextInt(10 ^ (sloznostIgri * 4));
            int b = random.nextInt(10 ^ (sloznostIgri * 4));
            int trueansver = a + b;

            System.out.println("Зеши пример: " + a + "+" + b);
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (ans == trueansver) {
                System.out.println("Ты ПоБЕдИл!!!");
                return true;
            } else {
                System.out.println("Ты ПРоИГраЛ(((");
                return false;
            }
        } else if (sloznostIgri == 5) {
            int a = random.nextInt(10 ^ (sloznostIgri * 5));
            int b = random.nextInt(10 ^ (sloznostIgri * 5));
            int trueansver = a + b;

            System.out.println("Зеши пример: " + a + "+" + b);
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (ans == trueansver) {
                System.out.println("Ты ПоБЕдИл!!!");
                return true;
            } else {
                System.out.println("Ты ПРоИГраЛ(((");
                return false;
            }
        }

        return false;
    }
}
