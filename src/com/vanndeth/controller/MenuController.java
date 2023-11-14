package com.vanndeth.controller;

import com.vanndeth.utils.Singleton;
import com.vanndeth.view.MenuView;

public class MenuController {
    private final MenuView menuView;
    public MenuController(){

        menuView = Singleton.menuView();
    }
    public void displayProductList() {
        menuView.menu();
    }
}
