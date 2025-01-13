import java.lang.String;

public class XHTMLAbbreviator_1_1 {
    public static void main(String[] args) {
        String xhtml = "<p>Proin tristique dapibus neque. Nam eget purus sit amet leo tincidunt accumsan.</p><p>Proin semper, orci at mattis blandit, augue justo blandit nulla. <span>Quisque ante congue justo</span>, ultrices aliquet, mattis eget, hendrerit, <em>justo</em>.</p>";
        String abbreviatedXHTML = XHTMLAbbreviator.abbreviateXHTML(xhtml, 25);
        System.out.println(abbreviatedXHTML);
    }
}