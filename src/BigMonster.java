import java.util.Random;
import java.util.Scanner;


static public class BigMonster extends Monster{
    BigMonster(int sizeBoard){
        super(sizeBoard);
        setImage("\uD83D\udc79");}
        @Override
        static public boolean taskMonster (int sloznostIgri){
            if (sloznostIgri == 1){
                return taskMonster();
            }else{
                System.out.println("Зеши задачу:");

                Random random = new Random();
                int minX = 10 * sloznostIgri;
                int maxX = 20 * sloznostIgri;
                int x = random.nextInt(maxX - minX) + minX;
                
                int minY = 10 * sloznostIgri;
                int maxY = 20 * sloznostIgri;
                int y = random.nextInt(maxX - minX) + minX;

                int minZ = 10 * sloznostIgri;
                int maxZ = 20 * sloznostIgri;
                int z = random.nextInt(maxX - minX) + minX;

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
        
    static public boolean taskMonster(){
            return super.taskMonster(1);
    }
}
