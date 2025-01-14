import java.lang.String;
public class DealCategory {
    public enum DealType {
        BASE(2L), 
        EXTRA(5L);
    
        private Long id;
    
        DealType(Long id) {
            this.id = id;
        }
    
        public Long getId() {
            return id;
        }
    }
    public static void main(String[] args) {
    }
}