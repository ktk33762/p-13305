package com.back.p13305.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/article/list";
    }

    @GetMapping("/article/list")
    public String list(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "article/list";
    }

    @GetMapping("/article/create")
    public String createForm() {
        return "article/create";
    }
}
