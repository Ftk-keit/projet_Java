package com.baf.vues;

import com.baf.entity.Article;
import com.baf.services.ArticleService;

public class ArticleVue extends ViewImpl<Article> {
    private ArticleService articleServices;

    public ArticleVue(ArticleService articleServices) {
        this.articleServices = articleServices;
    }

    public Article saisie() {
        Article article = new Article();
        boolean articleExist;
        do {
            System.out.println("Veuillez saisir le libelle");
            article.setLibelle(scanner.nextLine());
            articleExist = articleServices.selectByLibelle(article.getLibelle()) != null;
            if (articleExist) {
                System.out.println("Ooups !! Cet article exist deja");
                System.out.println("veuillez réessayer");
            }
        } while (article.getLibelle().trim() == "" || articleExist);

        do {
            System.out.println("Veuillez saisir la quantite en stock");
            article.setQteStock(scanner.nextInt());

        } while (article.getQteStock() < 0);

        do {
            System.out.println("Veuillez saisir le prix");
            article.setPrix(scanner.nextInt());

        } while (article.getPrix() < 0);
        return article;
    }
}