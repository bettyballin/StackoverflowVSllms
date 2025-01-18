import java.util.*;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.*;
import net.sf.jsqlparser.schema.*;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.relational.*;

public class Main_63 {
    public static void main(String args[]) throws Exception {
        // parse statement
        Select selectStmt = (Select) CCJSqlParserUtil.parse("SELECT * FROM my_table WHERE price > 100 ORDER BY price");

        PlainSelect plainSelect = (PlainSelect) selectStmt.getSelectBody();

        // manipulate SELECT fields
        List<SelectItem> items = plainSelect.getSelectItems();
        if(items.size() == 1 && items.get(0) instanceof AllColumns) {
            AllTableColumns newField = new AllTableColumns(new Table("my_table"));
            items.set(0, newField);
        }

        // manipulate WHERE clause
        Expression oldWhere = plainSelect.getWhere();
        GreaterThan gt = new GreaterThan();
        Column priceCol = new Column(new Table("my_table"), "price");
        LongValue longVal = new LongValue(100);
        gt.setLeftExpression(priceCol);
        gt.setRightExpression(longVal);

        // oldWhere = gt; //this will not work with different conditions, but gives you an idea of how to use this library for your needs
        plainSelect.setWhere(gt);

        // manipulate OrderBy clause
        List<OrderByElement> orderByElements = new ArrayList<>();
        Column colPrice = new Column(new Table("my_table"), "price");
        OrderByElement obe = new OrderByElement();
        obe.setExpression(colPrice);
        orderByElements.add(obe);
        plainSelect.setOrderByElements(orderByElements);

        // print manipulated SQL statement
        System.out.println(selectStmt.toString());
    }
}