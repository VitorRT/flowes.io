package br.com.bycoffe.flowes.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bycoffe.flowes.models.Workspace;

@RestController
public class WorkspaceController {
    
    @GetMapping("/api/v1/workspace")
    public Workspace returnWorkspace() {
        return new Workspace(1l, "NewTale Workspace 💌", LocalDate.now(), "Workspace para os projetos do desenvolvimento da New Tale","newtale_logo.png");
    }
}
