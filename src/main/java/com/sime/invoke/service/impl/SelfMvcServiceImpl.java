package com.sime.invoke.service.impl;

import com.sime.invoke.annaotation.FanService;
import com.sime.invoke.service.SelfMvcService;

@FanService("selfMvcServiceImpl")
public class SelfMvcServiceImpl implements SelfMvcService {
    @Override
    public String query(String name, String age) {
        return "name -- "+name+"age -- "+age;
    }
}
