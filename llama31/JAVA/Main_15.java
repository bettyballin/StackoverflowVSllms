public class Main_15 {
    public static void main(String[] args) {
        Aka[] aka = new Aka[] {
            new Aka("en", "English Title"),
            new Aka("es", "Spanish Title")
        };

        String sptitle = null;
        if (aka != null && aka.length > 0) {
            for (Aka ak : aka) {
                if (ak.getLang().equals("es")) {
                    sptitle = ak.getTitle();
                }
            }
        }
        System.out.println(sptitle);  // prints: Spanish Title
    }
}

class Aka {
    private String lang;
    private String title;

    public Aka(String lang, String title) {
        this.lang = lang;
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public String getTitle() {
        return title;
    }
}