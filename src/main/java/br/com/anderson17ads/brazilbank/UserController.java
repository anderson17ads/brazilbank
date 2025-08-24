package br.com.anderson17ads.brazilbank;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RequestMapping("/user")
@RestController
public class UserController {
    @GetMapping
    public String list(@RequestParam(value = "filter", required = false) String filter) {
        return (filter == null)
            ? "User List without param filter"
            : "User List with param filter " + filter;
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") String id) {
        return "User detail " + id;
    }

    @PostMapping
    public String create(@RequestBody JsonNode body) {
        return "Nome " + body.get("name").asText();
    }
}
