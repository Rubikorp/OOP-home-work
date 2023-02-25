package ru.gb.lesson4.hw;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> implements Iterable <T> {

    // Нужно реализовать хранение фрукто в коробке Box
    private List<T> fruitBox = new ArrayList<T>();


    public void add(T fruit) {
        // FIXME: 21.02.2023 Написать логику сохранения
        fruitBox.add(fruit);
    }

    public double getWeight() {
        // FIXME: 21.02.2023
        double weight = 0;
        for (T item : fruitBox) {
            weight += item.getWeight();
        }
    }

    public void moveTo(Box<? super T> anotherBox) {
        // FIXME: 21.02.2023
        for (int i = 0; i < fruitBox.size(); i++) {
            anotherBox.add(fruitBox.get(i));
        }
        fruitBox.clear();
    }

}
