
import java.util.Random;

public class BigMonster extends Monster {

    BigMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDC82");
    }
    
@Override
public boolean taskMonster(int sloznostIgri) {

    System.out.println("Реши простое задание: ");

    Random random = new Random();

    int x = 100 * sloznostIgri + random.nextInt(900 * sloznostIgri);
    int y = 2 + random.nextInt(5);
    int z = 2 + random.nextInt(sloznostIgri + 1);

    long trueAnswer = (long) (x * Math.pow(y, z));

    System.out.println(x + " * (" + y + " ^ " + z + ") = ?");

    int ans = scanner.nextInt();

    if (trueAnswer == ans) {
        System.out.println("ПРавльно");
        return true;
    } else {
        System.out.println("Правильный ответ: " + trueAnswer);
        return false;
    }
}
}
