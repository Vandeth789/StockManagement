package com.vanndeth.controller;

import com.vanndeth.view.MenuView;

public class MenuController {
    private final MenuView menuView;
    public MenuController(){

        menuView = new MenuView();
    }
    public void index() {
        menuView.menu();
    }
}
