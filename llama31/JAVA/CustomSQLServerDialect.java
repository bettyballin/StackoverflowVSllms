import org.hibernate.dialect.SQLServerDialect;

public class CustomSQLServerDialect extends SQLServerDialect {
 
    @Override
    public String getLikeEscape() {
        return "\\";
    }
 
    @Override
    public String escapeLike(String matchPattern) {
        return super.escapeLike(matchPattern.replace("_", "\\_"));
    }

	public static void main(String[] args) {
	}
}