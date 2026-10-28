import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster{
    BigMonster(int sizeBoard){
        super(sizeBoard);
        setImage("\uD83D\udc79");}
        @Override
        public boolean taskMonster (int sloznostIgri){
            if (sloznostIgri == 1){
                return taskMonster();
            }else{
                System.out.println("Зеши задачу:");

                Random random = new Random();
                int x = random.nextInt(10 * (sloznostIgri), 20 * sloznostIgri);
                int y = random.nextInt(30 * (sloznostIgri), 40 * sloznostIgri);
                int z = random.nextInt(100 * (sloznostIgri), 1000 * sloznostIgri);
                long trueAnswer = x * (y ^ z);
                System.out.println("Пример: " + x + " * (" + y + " ^ " + z + ")");
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();

                if (trueAnswer == ans){
                    System.out.println("Всё верно!");
                    return true;
                }else{
                    System.out.println("Нет конечно! Правильно: " + trueAnswer);
                    return false;
                }
            }
        }
        public boolean taskMonster(){
            return super.taskMonster(1);
    }
}