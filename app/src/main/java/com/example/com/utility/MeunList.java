package com.example.com.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 95016056 on 2017-05-24.
 */

public class MeunList {
    List<Map<String, String>> menuList = new ArrayList<Map<String, String>>();

    public List<Map<String, String>> set_menuList(){
        Map<String, String> menu1 = new HashMap<String, String>();
        Map<String, String> menu2 = new HashMap<String, String>();

        menu1.put("1", "내비선택");
        menu2.put("2", "API Key 세팅");

        menuList.add(menu1);
        menuList.add(menu2);

        return menuList;
    }
}
