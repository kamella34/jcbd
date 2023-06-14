package fr.diginamic.jdbc.dao;

import fr.diginamic.jdbc.jdbc.entites.Article;


import java.util.List;

public interface IArticleDao  {

    List<Article> extraire() throws Exception;

    void insert(Article article) throws Exception;
    int update(Article article) throws Exception;
    boolean delete(Article article) throws Exception;
}
