package tourstApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tourstApp.model.DemoModel;
import tourstApp.service.DemoService;

@RestController
@RequestMapping(value = "api/demo")
public class DemoController {

    @Autowired
    DemoService service;

    @GetMapping("/order")
    public int demoGet(){
        return service.returnResult();
    }

    @GetMapping("/demo")
    public String demoGetName(){
        DemoModel demo =  service.getDemoById(1);
        return demo.getName();
    }
}
