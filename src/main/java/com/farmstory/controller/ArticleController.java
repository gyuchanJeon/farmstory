package com.farmstory.controller;

import com.farmstory.dto.ArticleDTO;
import com.farmstory.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/article")
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(ArticleDTO articleDTO, Model model) {
        model.addAttribute("group", articleDTO.getGroup());
        model.addAttribute("cate", articleDTO.getCateNo());
        List<ArticleDTO> articleDTOs = articleService.getAllArticles()
                .stream()
                .filter (article -> article.getGroup().equals(articleDTO.getGroup()) &&
                        article.getCateNo() == articleDTO.getCateNo())
                .toList();
        model.addAttribute("articles", articleDTOs);
        return "/article/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("no") String no, Model model) {
        ArticleDTO article = articleService.getArticleById(no);
        model.addAttribute("article", article);
        model.addAttribute("cate", article.getCateNo());
        return "/article/view";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("no") String no, Model model) {
        ArticleDTO article = articleService.getArticleById(no);
        model.addAttribute("article", article);
        model.addAttribute("cate", article.getCateNo());
        return "/article/modify";
    }

    @GetMapping("/delete")
    public String delete(Model model) {

        return "/article/delete";
    }

    @GetMapping("/write")
    public String write(ArticleDTO articleDTO, Model model) {
        model.addAttribute("group", articleDTO.getGroup());
        model.addAttribute("cate", articleDTO.getCateNo());
        return "/article/write";
    }

    @PostMapping("/write")
    public String write(ArticleDTO articleDTO) {
        articleService.insertArticle(articleDTO);
        return "redirect:/article/list";
    }

}
