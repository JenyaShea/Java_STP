import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Restaurant {
    //Объявляем ArrayLists и Scanner
    ArrayList<Food> food;
    ArrayList<Tables> tables;
    ArrayList<Orders> orders;
    Scanner sc;

    public Restaurant() {
        tables = new ArrayList<>();
        food = new ArrayList<>();
        orders = new ArrayList<>();
        sc = new Scanner(System.in);
        ful_arr();
        showMenu();
    }

    private void showMenu() {
        // Главное Меню
        System.out.println("1 - Выбор столика и заказ");
        System.out.println("2 - Расчёт столика");
        System.out.println("3 - Добавить блюдо в меню");
        System.out.println("4 - Меню");
        try {
            switch (sc.nextInt()) {
                case 1 -> {
                    //Выбор столика и заказ
                    System.out.println("\n");
                    chooseTable();
                }
                case 2 -> {
                    //Расчёт столика
                    System.out.println("\n");
                    calculate_prices();
                }
                case 3 -> {
                    // Добавляем блюдо в меню
                    System.out.println("\n");
                    addDishes();
                }
                case 4 -> {
                    //Показываем меню
                    System.out.println("\n");
                    System.out.println("\nМеню:");
                    for (Food fd : food) {
                        System.out.println(food.indexOf(fd) + 1 + ")" + fd.getName() + " : " + fd.getPrice() + "Р");
                    }
                    System.out.println("\n");
                    showMenu();
                }
                default -> {
                }
            }
        } catch (InputMismatchException ignored) {
        }
    }

    private void addDishes() {
        // Функция в которой добавляем блюда в меню
        System.out.println("Наименование блюда:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Цена блюда:");
        int price = sc.nextInt();
        //Добавляем экземпляр класса в Arraylist food
        food.add(new Food(name, price));
        System.out.println("\nМеню:");
        for (Food fd : food) {
            // Выводим список блюд
            System.out.println(food.indexOf(fd) + 1 + ")" + fd.getName() + " : " + fd.getPrice() + "Р");
        }
        System.out.println("\n");
        showMenu();
    }

    private void ful_arr() {
        // заполняем Arraylist tables
        // 7 столиков
        for (int i = 1; i < 8; i++) {
            tables.add(new Tables(i));
        }
        // заполняем Arraylist food
        food.add(new Food("Борщ", 150));
        food.add(new Food("Суп куриный", 110));
        food.add(new Food("Картофель печёный", 60));
        food.add(new Food("Куриная котлета", 80));
        food.add(new Food("Плов", 70));
        food.add(new Food("Компот", 30));
        food.add(new Food("Чай", 20));

    }
    private void chooseTable() {
        //Выбор столика
        System.out.println("\n");
        for (Tables tb : tables) {
            String fr;
            //Вместо  значений boolean пишем статус
            if (!tb.isOccupied()) {
                fr = "Свободен";
            } else fr = "Занят";
            System.out.println("Номер столика: " + tb.getNum() + " : " + fr);
        }
        //Выбираем столик
        System.out.println("Выберите столик:");
        int table_num = sc.nextInt();
        for (Tables tb : tables) {
            //Занимаем столик меняя значения с false na true
            if (tb.getNum() == table_num) {
                tb.setOccupied(true);
            }
        }
        int ch_num;
        do {
            //Цикл в котором заказываем блюдо
            System.out.println("\n1 - Показать меню");
            System.out.println("2 - Заказать блюдо");
            System.out.println("3 - Выйти на главное меню");
            ch_num = sc.nextInt();
            try {
                switch (ch_num) {
                    case 1 -> {
                        System.out.println("\n");
                        System.out.println("\nМеню:");
                        for (Food fd : food) {
                            System.out.println(food.indexOf(fd) + 1 + ")" + fd.getName() + " : " + fd.getPrice() + "Р");
                        }
                    }
                    case 2 -> {
                        System.out.println("Введите наименование блюда:");
                        sc.nextLine();
                        String fd_name = sc.nextLine();
                        //Добавление заказа
                        for (Food fd : food) {
                            if (Objects.equals(fd.getName(), fd_name)) {
                                orders.add(new Orders(table_num,fd.getName(), fd.getPrice()));
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("\n");
                        showMenu();
                    }
                }
                } catch(InputMismatchException ignored){
                }

        } while (ch_num != 3) ;
    }
    private void calculate_prices() {
        //Выбор столика для расчёта
        System.out.println("\n");
        for (Tables tb : tables) {
            if (tb.isOccupied()) {
                System.out.println("Номер столика: " + tb.getNum() + " : " + "Занят");
            }

        }
        //Выбираем столик
        System.out.println("Выберите столик:");
        int table_num = sc.nextInt();
        for (Tables tb : tables) {
            //Расчитываем столик меняя значения с true на false
            if (tb.getNum() == table_num) {
                tb.setOccupied(true);
            }
        }
        //Расчёт
        // Складываем цены блюд и составляем список всех заказаных блюд
        StringBuilder fd_names = new StringBuilder();
        int calc_sum = 0;
        for (Orders od: orders){
            if (od.getNum() == table_num){
                assert false;
                fd_names.append(od.getFood_names()).append(" ");
                calc_sum += od.getFood_prices();
            }
        }
        System.out.println("Столик " + table_num + " рассчитан" + "\nСписок блюд: " + fd_names + "\nCумма заказа: " + calc_sum);
    }
}
