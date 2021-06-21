import ru.geekbrains.Animal;
import ru.geekbrains.Cat;
import ru.geekbrains.Dog;

public class Main {

    // 3) Полимофизм
    // переопределение методов
    // параметрический полиморфизм

    public static void main(String[] args) {
        Animal[] zoo = {
                new Dog(),
                new Cat()
        };
        for (int i = 0; i < zoo.length; i++) {
//            zoo[i].voice();
        }
    }


}
