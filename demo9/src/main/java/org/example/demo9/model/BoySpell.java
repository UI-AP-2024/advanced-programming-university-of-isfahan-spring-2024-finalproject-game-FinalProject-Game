package org.example.demo9.model;

public class BoySpell implements Spell{
    private int price=500;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void drop() {

    }
}
