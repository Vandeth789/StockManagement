package com.vanndeth.utils;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MessageUtil {
    public static void message(String msg){
        Table tableMessage = new Table(1, BorderStyle.DESIGN_CAFE_WIDE, ShownBorders.SURROUND);
        tableMessage.addCell(msg);
        System.out.println(tableMessage.render());
    }
}
