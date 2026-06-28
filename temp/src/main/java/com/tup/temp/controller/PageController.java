package com.tup.temp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    //starts
    @GetMapping("/login")
    public String loginPage() {
        return "starts/login";
    }
    @GetMapping("/register")
    public String registerPage() {
        return "starts/register";
    }

    //admins
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin_route/dashboard";
    }
    @GetMapping("/admin/books")
    public String booksPage() {
        return "admin_route/books";
    }

    @GetMapping("/admin/books/add")
    public String addBookPage() {
        return "admin_route/add-book";
    }

    @GetMapping("/admin/books/edit/{id}")
    public String editBookPage() {
        return "admin_route/edit-book";
    }
    @GetMapping("/admin/bookings")
    public String bookingsPage() {
        return "admin_route/bookings";
    }
    @GetMapping("/admin/fines")
    public String finesPage() {
        return "admin_route/fines";
    }

    //member
    @GetMapping("/member/dashboard")
    public String memberDashboard() {
        return "member_route/dashboard";
    }
    @GetMapping("/member/books")
    public String memberBooksPage() {
        return "member_route/books";
    }

    @GetMapping("/member/bookings")
    public String memberBookingsPage() {
        return "member_route/bookings";
    }
    @GetMapping("/member/fines")
    public String memberFinesPage() {
        return "member_route/fines";
    }
    @GetMapping("/member/profile")
    public String memberProfilePage() {
        return "member_route/profile";
    }

}