import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Notebook {
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    // Конструктор
    public Notebook(String brand, String model, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    // Сеттеры
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


// А вот код для создания множества ноутбуков:
Set<Notebook> notebooks = new HashSet<>();
notebooks.add(new Notebook("Apple", "MacBook Pro", 8, 256, "macOS", "Silver"));
notebooks.add(new Notebook("Dell", "XPS 13", 8, 256, "Windows 10", "Silver"));
notebooks.add(new Notebook("Asus", "ZenBook", 16, 512, "Windows 10", "Blue"));
notebooks.add(new Notebook("Lenovo", "ThinkPad T14s", 16, 512, "Windows 10", "Black"));


// А вот код для метода фильтрации:
public static void filterNotebooks(Set<Notebook> notebooks) {
    Scanner scanner = new Scanner(System.in);

    // Запрос критериев фильтрации
    Map<Integer, String> criteria = new HashMap<>();
    criteria.put(1, "ram");
    criteria.put(2, "storage");
    criteria.put(3, "os");
    criteria.put(4, "color");

    System.out.println("Выберите критерий фильтрации:");
    for (Integer key : criteria.keySet()) {
        System.out.printf("%d - %s\n", key, criteria.get(key));
    }

    int choice = scanner.nextInt();
    String filterCriteria = criteria.get(choice);

    // Запрос минимальных значений критериев фильтрации
    Map<String, Integer> filterValues = new HashMap<>();
    for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
        System.out.printf("Введите минимальное значение для %s: \n", entry.getValue());
        int value = scanner.nextInt();
        filterValues.put(entry.getValue(), value);
    }

    // Фильтрация ноутбуков
    Set<Notebook> filteredNotebooks = new HashSet<>();
    for (Notebook notebook : notebooks) {
        if (notebook.getRam() >= filterValues.get("ram")
                && notebook.getStorage() >= filterValues.get("storage")
                && notebook.getOs().equals(filterValues.get("os"))
                && notebook.getColor().equals(filterValues.get("color"))) {
            filteredNotebooks.add(notebook);
        }
    }

    // Вывод результата
    System.out.println("Результаты фильтрации:");
    for (Notebook notebook : filteredNotebooks) {
        System.out.printf("%s %s: RAM=%d ГБ, хранилище=%d ГБ, ОС=%s, цвет=%s\n",
                notebook.getBrand(),
                notebook.getModel(),
                notebook.getRam(),
                notebook.getStorage(),
                notebook.getOs(),
                notebook.getColor());
    }
}