import java.lang.String;

public class CopyrightNotice {
    String copyright = "\u00A9 2003-2008 My Company. All rights reserved.";

    public static void main(String[] args) {
        CopyrightNotice notice = new CopyrightNotice();
        System.out.println(notice.copyright);
    }
}