package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dao.entities.Congé;
import com.example.demo.service.CongéService;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private CongéService congéService;

    // Endpoint pour récupérer tous les congés
    // Endpoint pour récupérer tous les congés
    @GetMapping
    public ResponseEntity<List<Congé>> getAllLeaves() {
        List<Congé> leaves = congéService.getAllWithoutPagination();
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }


    // Endpoint pour créer un nouveau congé
    @PostMapping
    public ResponseEntity<Congé> createLeave(@RequestBody Congé congé) {
        Congé createdLeave = congéService.add(congé);
        return new ResponseEntity<>(createdLeave, HttpStatus.CREATED);
    }

    // Endpoint pour récupérer tous les congés
    @GetMapping
    public ResponseEntity<List<Congé>> getAllLeaves(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Congé> leavesPage = congéService.getAll(page, size);
        List<Congé> leaves = leavesPage.getContent();
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }


    // Endpoint pour mettre à jour un congé
    @PutMapping("/{id}")
    public ResponseEntity<Congé> updateLeave(@PathVariable Long id, @RequestBody Congé congé) {
        congé.setId(id); // Assurez-vous que l'ID est correctement défini pour la mise à jour
        Congé updatedLeave = congéService.update(congé);
        if (updatedLeave != null) {
            return new ResponseEntity<>(updatedLeave, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un congé par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        if (congéService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
