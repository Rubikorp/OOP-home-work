package lesson3;

import java.util.ArrayList;
import java.util.List;

// Создать класс Notebook с полями (price(double), ram(int))
// 1. Сгенерировать список объектов типа Notebook с разными значениям price и ram
// 2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по памяти, потом по цене
// 3. Отсортировать тремя способами стандартными средствами (Collections#sort или List#sort)
// Повторить про Iterator и Iterable


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook(2300, 8));
        notebooks.add(new Notebook(2030, 12));
        notebooks.add(new Notebook(2000, 8));
        notebooks.add(new Notebook(300, 16));
        notebooks.add(new Notebook(12500, 16));

        /**Сортировка 1.
         * Сортировка по цене по классу "PriceValueComparator"
         */
       Comparator<Notebook> PriceComparator = new PriceValueComparator();
       Collections.sort(notebooks, PriceComparator);
       for (Notebook notebook: notebooks) {
           notebook.printNotebook();
       }




        /**Сортировка 2.
         * Сортировка по значению оперативной памяти с помощью ссылки на метод
         */
       Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam));
       for (Notebook notebook: notebooks) {
           notebook.printNotebook();
       }




        /**Сортировка 3.
         * Сортировка сначала по памяти, потом по цене
         */
       Collections.sort(notebooks, Comparator.comparingInt(Notebook::getRam)
               .thenComparingDouble(Notebook::getPrice));
       for (Notebook notebook : notebooks) {
           notebook.printNotebook();
       }

    }

    /**Класс служит каркасом для элементов списка ноутбуков
     *
     * getPrice() - возвращает значение цены
     * getRam() - возвращает значение оперативной памяти
     * printNotebook() - Выводит в консоль все значения элемента списка
     */
    public static class Notebook {
        private double price;
        private int ram;

        public Notebook(double price, int ram) {
            this.price = price;
            this.ram = ram;
        }

        public double getPrice() {
            return price;
        }

        public int getRam() {
            return ram;
        }


        public String printNotebook() {
            System.out.println("price: " + price + "; RAM: " + ram + ";");
            return null;
        }
    }

    /**
     * Класс сортировки по цене
     */
    public static class PriceValueComparator implements Comparator<Notebook> {

        @Override
        public int compare(Notebook o1, Notebook o2) {
            return (int) (o1.getPrice() - o2.getPrice());
        }
    }


}