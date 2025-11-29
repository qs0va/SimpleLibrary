/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.dynamika.testtask.sb.simplelibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dynamika.testtask.sb.simplelibrary.models.Client;
import ru.dynamika.testtask.sb.simplelibrary.services.ClientService;

/**
 *
 * @author qs0va_
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public String clientsPage(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients/index";
    }

    @GetMapping("/new")
    public String newClientPage(Model model) {
        model.addAttribute("client", new Client());
        return "clients/new";
    }

    @GetMapping("/{id}/edit")
    public String editClientPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("client", clientService.findCLient(id));
        return "clients/edit";
    }

    @PostMapping("")
    public String newClient(@ModelAttribute("client") Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }

    @PostMapping("/{id}/edit")
    public String editClient(@PathVariable("id") Long id, @ModelAttribute("client") Client client) {
        clientService.updateClient(id, client);
        return "redirect:/clients";
    }
}
