
import java.util.Random;

public class BigMonster extends Monster {

    BigMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDC79");
    }

    @Override
    public boolean taskMonster(int sloznostIgri) {

        System.out.println("Большой монстр предлагает задание!");
        System.out.println("Реши задачу:");

        Random random = new Random();

        int minX = 1;
        int maxX = 10 * sloznostIgri;

        int x = random.nextInt(maxX) + minX;

        int y = 2 + random.nextInt(4);

        int z = 1 + random.nextInt(sloznostIgri + 1);

        long trueAnswer = (long) (x * Math.pow(y, z));

        System.out.println("Пример: " + x + " * (" + y + " ^ " + z + ")");

        int ans = scanner.nextInt();

        if (trueAnswer == ans) {
            System.out.println("Всё верно! Большой монстр побеждён!");
            return true;
        } else {
            System.out.println("Неправильно! Правильный ответ: "
                    + trueAnswer);
            return false;
        }
    }
}

