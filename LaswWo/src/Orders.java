import java.util.ArrayList;
//Класс в котором формируются заказы
public class Orders {
    // Номер столика, arlist с названиями блюд, arlist с ценами
    int num;
    private String food_names;
    private int food_prices;
    //Конструктор
    public Orders(int num,String food_names, int food_prices){
        this.food_names = food_names;
        this.num = num;
        this.food_prices = food_prices;
    }
    // Setters and Getters


    public void setFood_prices(int food_prices) {
        this.food_prices = food_prices;
    }

    public int getFood_prices() {
        return food_prices;
    }

    public void setFood_names(String food_names) {
        this.food_names = food_names;
    }

    public String getFood_names() {
        return food_names;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

