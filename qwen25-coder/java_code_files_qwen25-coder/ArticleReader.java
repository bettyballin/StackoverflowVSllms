public class ArticleReader {

    private SomeClass f;
    private Article article;

    public ArticleReader() {
        f = new SomeClass();
        article = new Article();

        Article article2 = f.daoArticle.findById(article.getSrcUrl());
        String vbody = article2.getArticle();
        System.out.println(vbody);
    }

    public static void main(String[] args) {
        new ArticleReader();
    }
}

class SomeClass {
    DaoArticle daoArticle = new DaoArticle();
}

class DaoArticle {
    public Article findById(String id) {
        return new Article();
    }
}

class Article {
    public String getSrcUrl() {
        return "exampleUrl";
    }

    public String getArticle() {
        return "example article body";
    }
}