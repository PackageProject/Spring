package com.example.demo.api;


import com.example.demo.entity.Menu;
import com.example.demo.repository.MenusRepository;
import com.example.demo.service.MenusService;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenusApiController {
    private final MenusRepository menusRepository;

    @Autowired
    public MenusApiController(MenusRepository menusRepository) {
        this.menusRepository = menusRepository;
    }

    @GetMapping
    public Iterable<Menu> list() {
        return menusRepository.findAll();
    }

    @PostMapping("/{storesid}")
    public Menu menuInsert(@RequestBody Menu menu) {
        return menusRepository.save(menu);
    }


    @GetMapping("/{menusid}")
    public Optional<Menu> getMenuById(@PathVariable Long menusid) {
        return menusRepository.findById(menusid);
    }

    @PutMapping("/{menusid}")
    public Menu updateMenu(@PathVariable Long menusid, @RequestBody Menu updatedMenu) {
        Optional<Menu> optionalMenu = menusRepository.findById(menusid);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.setStoresid(updatedMenu.getStoresid());
            menu.setMenusname(updatedMenu.getMenusname());
            menu.setPrices(updatedMenu.getPrices());
            return menusRepository.save(menu);
        } else {
            throw new IllegalArgumentException("Menu not found with ID: " + menusid);
        }
    }

    @DeleteMapping("/{menusid}")
    public void deleteMenu(@PathVariable Long menusid) {
        menusRepository.deleteById(menusid);
    }




}
