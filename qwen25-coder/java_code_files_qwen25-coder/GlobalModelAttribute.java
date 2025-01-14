import java.lang.String;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttribute {

    @Value("${img.breadcrumbs.next}")
    private String imgBreadcrumbsNext;

    @ModelAttribute("img")
    public void addCommonResources(Model model) {
        model.addAttribute("img", new CommonPaths(imgBreadcrumbsNext));
    }

    public static class CommonPaths {
        private final String breadcrumbsNext;

        public CommonPaths(String breadcrumbsNext) {
            this.breadcrumbsNext = breadcrumbsNext;
        }

        public String getBreadcrumbsNext() {
            return breadcrumbsNext;
        }
    }

	public static void main(String[] args) {
	}
}