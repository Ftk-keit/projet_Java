package com.baf.data.entities;
import java.util.List;

import lombok.Data;

@Data

public class Article {
    private int id;
    private String libelle;
    private int qteStock;
    private int prix;
    private List<DetailDebtRequest> detailDebts;
    private static int nbre = 0;
    public Article() {
        id = nbre++;
    }
    @Override
    public String toString() {
        return "Article [id=" + id + ", libelle=" + libelle + ", qteStock=" + qteStock + ", prix=" + prix + "]";
    }
}