package br.com.aweb.to_do_list.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.to_do_list.model.Todo;
import br.com.aweb.to_do_list.repository.TodoRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping 
    public ModelAndView list (){
       // var ModelAndView = new ModelAndView("list");
        //ModelAndView.addObject("todos", todoRepository.findAll());
       // return ModelAndView;
      // return new ModelAndView("list", Map.of("todos", todoRepository.findAll())

       return new ModelAndView("list", Map.of("todos",
        todoRepository.findAll(Sort.by("deadline"))));
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("form", Map.of("todo", new Todo()));
    }

    @PostMapping("/create")
    public String create(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors())
            return "form";
        todoRepository.save(todo);
        return "redirect:/todo";
    }
}
