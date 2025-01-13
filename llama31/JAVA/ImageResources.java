import java.lang.String;

import javax.annotation.Resource;
import javax.inject.Named;

@Named
@ResourceBundle("images")
public class ImageResources {
    @Value("${img.breadcrumbs.next}")
    public String imgBreadcrumbsNext;

    public static void main(String[] args) {
    }
}