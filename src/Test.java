import java.util.Scanner;

public class Test {
    void main() {
        System.out.println("Здравствуй, путник! Видно давно ты в пути. Пройди моё испытание и получи в награду 100 золотых монет!" + "\n(введите ДА / НЕТ с учетом регистра)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case ("ДА"):
                System.out.println("Знал что ты согласишься, 100 золотых всётаки много");
                System.out.println("Тебе надо ответить правильно на 2 вопроса, если сможешь - 100 золотых твои" + "\nЕсли нет - увы, но я тебя убью(");
                System.out.println("Готов к вопросам?" + "\n(напиши ДА/НЕТ с учетом регистра)");
                String questionS = scanner.nextLine();
                switch (questionS){
                    case ("ДА"):
                        System.out.println("Прекрастно, начнем!");
                        System.out.println("Вопрос 1." + "\nКак тебя зовут?");
                        String an1 = scanner.nextLine();
                        System.out.println("Прекрастно! Будем знакомы, " + an1 + ", что-бы это не значило...");
                        System.out.println("Ну на 1 вопрос ты ответил, следующий: куда ты идёшь?");
                        String an2 = scanner.nextLine();
                        System.out.println("Прекрастно! Я кастати тоже иду в " + an2 + ", где бы это не было.");
                        System.out.println("Ну вот, а ты боялся! Вот твои 100 золотых");
                        System.out.println("Вы получили 100 золотых");
                        System.out.println("Прощай!");
                        System.out.println(" ");
                        System.out.println("Конец!");
                    case ("НЕТ"):
                        System.out.println("Мне кажется ты сказал да. Прости, не понимаю твой язык, начнем!");
                        System.out.println("Вопрос 1." + "\nКак тебя зовут?");
                        String an3 = scanner.nextLine();
                        System.out.println("Прекрастно! Будем знакомы, " + an3 + ", что-бы это не значило...");
                        System.out.println("Ну на 1 вопрос ты ответил, следующий: куда ты идёшь?");
                        String an4 = scanner.nextLine();
                        System.out.println("Прекрастно! Я кастати тоже иду в " + an4 + ", где бы это не было.");
                        System.out.println("Ну вот, а ты боялся! Вот твои 100 золотых");
                        System.out.println("Вы получили 100 золотых");
                        System.out.println("Прощай!");
                        System.out.println(" ");
                        System.out.println("Конец!");
                    default:
                        System.out.println(" ");
                }
                break;
            case ("НЕТ"):
                System.out.println("Ну нет так нет. Кому-то эти 100 золотых нужнее, мнееее)))");
                break;
            default:
                System.out.println("Прости, не говорю на твоём языке. Приходи как выучишь мой)");
        }
    }
}
