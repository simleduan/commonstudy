package com.sime.invoke.controller;

import com.sime.invoke.annaotation.FanAutowired;
import com.sime.invoke.annaotation.FanController;
import com.sime.invoke.annaotation.FanRequestMapping;
import com.sime.invoke.annaotation.FanRequestParam;
import com.sime.invoke.service.SelfMvcService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@FanController
@FanRequestMapping("/fan")
public class SelfMvcController {

    @FanAutowired("selfMvcServiceImpl") //map.get(key)
    private SelfMvcService selfMvcService;

    @FanRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @FanRequestParam("name") String name,@FanRequestParam("age") String age){
        try {
            PrintWriter writer = response.getWriter();
            String query = selfMvcService.query(name, age);
            writer.write(query);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
