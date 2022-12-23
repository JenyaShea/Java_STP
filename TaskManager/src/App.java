import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class App {
    ArrayList<Task> tasks;
    Scanner sc;
    int id;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


    public App(){
        tasks = new ArrayList<>();
        sc = new Scanner(System.in);
        id = 0;
        showMenu();
    }

    private void showMenu(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("1 - Создать задачу");
        System.out.println("2 - Удалить задачу");
        System.out.println("3 - Отредактировать задание");
        System.out.println("4 - Посмотреть задачи");
        System.out.println("5 - Посмотреть выполненные задачи");
        System.out.println("6 - Посмотреть невыполненных задач");
        System.out.println("7 - Посмотреть список по дате выполнения");
        System.out.println("8 - Посмотреть список по дате создания");
        System.out.println("9 - Детальное описание задачи");
        System.out.println("0 - Выход");
        try{
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.println("\n");
                    createTask();
                }
                case 2 -> {
                    System.out.println("\n");
                    displayTasks();
                    delTask();
                }
                case 3 -> {
                    System.out.println("\n");
                    displayTasks();
                    editTask();
                }
                case 4 -> {
                    System.out.println("\n");
                    displayTasks();
                    showMenu();
                }
                case 5 -> {
                    System.out.println("\n");
                    displayCT();
                    showMenu();
                }
                case 6 -> {
                    System.out.println("\n");
                    displayUnT();
                    showMenu();
                }
                case 7 -> {
                    System.out.println("\nДата выполнения:");
                    showByCompDate(dateInput());
                    showMenu();
                }
                case 8 -> {
                    System.out.println("\n");
                    System.out.println("Дата создания:");
                    showByCreationDate(dateInput());
                    showMenu();
                }
                case 9 -> {
                    System.out.println("\n");
                    displayTasks();
                    displayDesc();
                }
                case 0 -> {
                    exit(0);
                }
                default -> {
                }
            }
        } catch (InputMismatchException ignored){
        }
    }

    private LocalDate dateInput(){
        LocalDate ldate;
        while (true)
        {
            try{
                String date = sc.next();
                ldate = LocalDate.parse(date,formatter);
            } catch (java.time.format.DateTimeParseException e){
                System.out.println("Введите ещё раз (01/01/2023)*!");
                continue;
            }
            break;
        }
        return ldate;
    }
    //Создание задачи
    private void createTask(){

        System.out.println("Наименование задачи:");
        String name = sc.next();

        System.out.println("Описание задачи:");
        String details= sc.next();

        LocalDate di;

        System.out.println("Введите дату выполнения (дд/мм/гггг)");
        di = dateInput();
        tasks.add(new Task(id, name, details,LocalDate.now(), di));
        id += 1;
        System.out.println("\n");
        showMenu();
    }
    //Отображение всех задач
    private void displayTasks(){
        System.out.println("Список задач:");
        for (Task task : tasks) {
            System.out.println(tasks.indexOf(task) + " : " + task.getTitle());
        }
        System.out.println("\n");
    }

    //Отображение по дате выполнения
    private void showByCompDate(LocalDate dt){
        System.out.println("Задачи для выполнения " + dt.toString());
        for (Task task : tasks) {
            if (task.getEndDate().equals(dt))
                System.out.println(tasks.indexOf(task) + " : " + task.getTitle());
        }
        System.out.println("\n");
    }
    //Отображение по дате
    private void showByCreationDate(LocalDate dt){
        System.out.println("Список задач, созданных " + dt.toString());
        for (Task task : tasks) {
            if (task.getCrDate().equals(dt))
                System.out.println(tasks.indexOf(task) + " : " + task.getTitle());
        }
        System.out.println("\n");
    }
    //Редактирование
    private void editTask(){

        System.out.println("Номер задачи для редактирования:");

        try{
            int taskID = sc.nextInt();
            try{
                Task nowTask = tasks.get(taskID);
                int id = nowTask.getId();
                String name = nowTask.getTitle();
                String details = nowTask.getDescription();
                LocalDate crDate = nowTask.getCrDate();
                LocalDate comDate = nowTask.getEndDate();
                System.out.println("|------------------|");
                System.out.println("1 - Наименование: " + name);
                System.out.println("2 - Описание: " + details);
                System.out.println("3 - Дата выполнения: " + comDate.toString());
                System.out.println("-------------------|");
                System.out.println("Что вы хотите изменить? (1-3 выбор, все остальное вернуться в меню)");
                try{
                    switch (sc.nextInt()) {
                        case 1 -> {
                            System.out.println("Введите наименование задачи:");
                            name = sc.next();
                        }
                        case 2 -> {
                            System.out.println("Измените описание:");
                            details = sc.next();
                        }
                        case 3 -> {
                            System.out.println("Измените дату выполнения (дд/мм/гггг):");
                            comDate = dateInput();
                        }
                        default -> {
                        }
                    }
                    tasks.set(taskID, new Task(id, name, details, crDate, comDate));
                } catch (InputMismatchException ignored){}
            } catch (IndexOutOfBoundsException e) {System.out.println("Такой номер отсутствует");}
        } catch (InputMismatchException e) {System.out.println("Цифры");}

        showMenu();
    }
    //Удаление задач
    private void delTask(){
        try{
            System.out.println("Номер задачи для удаления:");
            tasks.remove(sc.nextInt());
            System.out.println("\n");
        } catch (IndexOutOfBoundsException e) {System.out.println("Номер отсутствует!");}
        showMenu();
    }
    //Выполненные задачи
    private void displayCT(){
        System.out.println("Выполненные задачи:");
        for (Task task : tasks) {
            if (task.getCompetable())
                System.out.println(tasks.indexOf(task) + " : " + task.getTitle());
        }
        System.out.println("\n");
    }
    //Невыполненные задачи
    private void displayUnT(){
        System.out.println("Невыполненных задачи:");
        for (Task task : tasks) {
            if (!task.getCompetable())
                System.out.println(tasks.indexOf(task) + " : " + task.getTitle());
        }
        System.out.println("\n");
    }
    private void displayDesc(){
        System.out.println("Детальное описание задачи:");

        try{
            int taskID = sc.nextInt();
            try{
                Task nowTask = tasks.get(taskID);
                int id = nowTask.getId();
                String name = nowTask.getTitle();
                String details = nowTask.getDescription();
                LocalDate crDate = nowTask.getCrDate();
                LocalDate endDate = nowTask.getEndDate();
                System.out.println("|------------------|");
                System.out.println("1 - ID: " + nowTask.getId());
                System.out.println("2 - Наименование: " + name);
                System.out.println("3 - Описание: " + details);
                System.out.println("4 - Дата Создание: " + crDate.toString());
                System.out.println("5 - Дата выполнения: " + endDate.toString());
                System.out.println("-------------------|");
            } catch (IndexOutOfBoundsException e) {System.out.println("Такой номер отсутствует");}
        } catch (InputMismatchException e) {System.out.println("Цифры");}

        showMenu();
    }
}