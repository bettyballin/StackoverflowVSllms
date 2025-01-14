import java.util.ArrayList;
import java.util.List;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.Statement;

public class SQLManipulator {
    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM my_table WHERE price < 50";
        
        // Parse the SQL statement
        Select selectStatement = (Select) CCJSqlParserUtil.parse(sql);
        PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();
        
        // Add a new criteria
        GreaterThan greaterThan = new GreaterThan();
        greaterThan.setLeftExpression(new Column("price"));
        greaterThan.setRightExpression(new LongValue(100));

        if (plainSelect.getWhere() != null) {
            plainSelect.setWhere(new AndExpression(plainSelect.getWhere(), greaterThan));
        } else {
            plainSelect.setWhere(greaterThan);
        }
        
        // Add an order by clause
        List<OrderByElement> orderByElements = new ArrayList<OrderByElement>();
        OrderByElement orderByElement = new OrderByElement();
        orderByElement.setExpression(new Column("price"));
        orderByElements.add(orderByElement);
        plainSelect.setOrderByElements(orderByElements);

        // Modify the select statement if necessary
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        SelectItem selectItem = new SelectExpressionItem(new Column("my_table.*"));
        selectItems.add(selectItem);
        plainSelect.setSelectItems(selectItems);

        System.out.println(selectStatement.toString());
    }
}