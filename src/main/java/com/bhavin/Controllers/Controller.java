package com.bhavin.Controllers;

/**
 * Created by bhavinchauhan on 5/17/16.
 */

import com.bhavin.Services.CSVToEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class Controller {
    @Autowired
    CSVToEntity csvToEntity;

    @RequestMapping("/")
    public String test(@RequestParam(value = "name", required = false, defaultValue = "Test") String name, Model model) {
        model.addAttribute("name", name);
        return "test";
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String write(@RequestParam(value = "path", required = true) String path) {
        try {
            csvToEntity.write(path);
        } catch (Exception e) {
            return "failure";
        }
        return "success";
    }

    @RequestMapping("/read")
    public @ResponseBody String read(@RequestParam(value = "tripId", required = true) String tripId,
                @RequestParam(value = "tripDate", required = true) String tripDate,
                @RequestParam(value = "routeId", required = true) String routeID) throws IOException {
         System.out.println("tripId" + tripId + "tripDate" + tripDate + "routeId" + routeID);
         return csvToEntity.read(tripDate, tripId, routeID);

    }

}
