public class Food {
    // Класс в котором хранится информация о блюдах
    // Цена и Наименование
    private String name;
    private int price;
    // Конструктор
    public Food(String name, int price){
        this.name = name;
        this.price = price;
    }
    // Getters и Setters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

