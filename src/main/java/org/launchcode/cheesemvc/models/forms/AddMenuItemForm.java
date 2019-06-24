package org.launchcode.cheesemvc.models.forms;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {
    @NotNull
    private Menu menu;
    @NotNull
    private Iterable<Cheese> cheeses;
    @NotNull
    private int menuId;
    @NotNull
    private int cheeseId;

    public AddMenuItemForm() {
    }

    public AddMenuItemForm(Menu menu, Iterable<Cheese> cheeses) {
        this.menu = menu;
        this.cheeses = cheeses;
    }

    public Menu getMenu() {
        return menu;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getCheeseId() {
        return cheeseId;
    }
}
