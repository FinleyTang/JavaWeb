package com.example.mybookapp.controller;

import com.example.mybookapp.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("Title1", "Author1"));
        books.add(new Book("Title2", "Author2"));
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/addBook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBookSubmit(@ModelAttribute Book book) {
        books.add(book);
        return "redirect:/books";
    }
}
