import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.sql.SQLExpressions;
import com.querydsl.sql.SQLQuery;

public class Main_262 {
    public static void main(String[] args) {
        // Constructing a SQL query using Querydsl
        SQLQuery<?> query = SQLExpressions.select("DATE", "QUOTE")
            .from("STOCKMARKET")
            .where(Expressions.eq("CORP", "?")) // '?' is likely a placeholder for an actual value
            .orderBy("DATE", SQLExpressions.DESC);
        
        // Printing the constructed SQL query
        System.out.println(query.toString());
    }
}