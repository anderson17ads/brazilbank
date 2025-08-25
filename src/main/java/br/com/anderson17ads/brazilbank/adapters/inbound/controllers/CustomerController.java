package br.com.anderson17ads.brazilbank.adapters.inbound.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer")
@RestController
public class CustomerController {
    @GetMapping
    public String list(@RequestParam(value = "filter", required = false) String filter) {
        return (filter == null)
            ? "Customer List without param filter"
            : "Customer List with param filter " + filter;
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") String id) {
        return "Customer detail " + id;
    }

    @PostMapping
    public String create(@RequestBody JsonNode body) {
        return "Nome " + body.get("name").asText();
    }
}
