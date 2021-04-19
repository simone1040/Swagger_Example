package it.com.swaggerAPI.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.com.swaggerAPI.demo.model.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@RequestMapping("/api")
@RestController
public class AddressBookResource {
    private ConcurrentHashMap<Integer, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id]")
    @ApiOperation(value = "Get contact", notes = "Get contact by ID")
    public Contact getContact(
            @ApiParam(name = "id", value = "Unique id of contact in list") @PathVariable Integer id){
        return contacts.get(id);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get all contact", notes = "Get all contacts")
    public List<Contact> getAllContact(){
        return new ArrayList<>(contacts.values());
    }

    @PostMapping("/")
    @ApiOperation(value = "Add contact", notes = "Add contact to contact list")
    public Contact addContact(
            @ApiParam(name = "contact",
                    value = "Add contact to contact list")
            @RequestBody Contact contact){
        this.contacts.put(contact.getId(),contact);
        return contact;
    }
}
