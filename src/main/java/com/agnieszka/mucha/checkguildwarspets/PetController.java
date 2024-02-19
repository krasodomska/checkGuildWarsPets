package com.agnieszka.mucha.checkguildwarspets;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class PetController {
    static public Pet getPet(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format("https://api.guildwars2.com/v2/pets/%s", id), Pet.class);
    }
}
