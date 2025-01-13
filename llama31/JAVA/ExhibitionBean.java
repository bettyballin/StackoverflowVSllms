import javax.enterprise.context.RequestScoped;

class Exhibition {
    // Add properties and methods for Exhibition class
}

@RequestScoped
public class ExhibitionBean {
    private Exhibition currentExhibition;

    // getters and setters
    public Exhibition getCurrentExhibition() {
        return currentExhibition;
    }

    public void setCurrentExhibition(Exhibition currentExhibition) {
        this.currentExhibition = currentExhibition;
    }

    public static void main(String[] args) {
    }
}