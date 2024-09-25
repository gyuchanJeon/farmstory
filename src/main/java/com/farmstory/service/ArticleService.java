package com.farmstory.service;

import com.farmstory.dto.ArticleDTO;
import com.farmstory.entity.Article;
import com.farmstory.repository.ArticleRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public void insertArticle(ArticleDTO article) {
        articleRepository.save(article.toEntity());
    }
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDTO> list = articles
                        .stream()
                        .map(Entity -> Entity.toDTO())
                        .toList();
        return list;
    }
    public ArticleDTO getArticleById(String id) {
        int a_no = Integer.valueOf(id);
        Optional<Article> opt = articleRepository.findById(a_no);
        if (opt.isPresent()) {
            Article article = opt.get();
            return article.toDTO();
        }
        return null;
    }
    public void updateArticle(ArticleDTO article) {
        boolean result = articleRepository.existsById(article.getANo());
        if (result) {
            articleRepository.save(article.toEntity());
        }
    }
    public void deleteArticle(String id) {
        int a_no = Integer.valueOf(id);
        articleRepository.deleteById(a_no);
    }
}
