import java.util.Collections;
import java.util.List;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectItem;

public class SQLDeconstructor {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT * FROM my_table WHERE price > 50";

        Statement statement = CCJSqlParserUtil.parse(sql);
        Select selectStatement = (Select) statement;
        PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();

        // Get the current criteria
        Expression whereExpression = plainSelect.getWhere();

        // Add a new criteria
        Expression newCriteria = CCJSqlParserUtil.parseCondExpression("price > 100");
        plainSelect.setWhere(whereExpression == null ? newCriteria : whereExpression.and(newCriteria));

        // Get the current order by clause
        List<OrderByElement> orderByElements = plainSelect.getOrderByElements();

        // Add a new order by clause
        if (orderByElements == null) {
            orderByElements = new java.util.ArrayList<>();
        }
        OrderByElement newOrderBy = new OrderByElement();
        newOrderBy.setExpression(new Column("price"));
        newOrderBy.setAsc(true);
        orderByElements.add(newOrderBy);
        plainSelect.setOrderByElements(orderByElements);

        // Get the current select clause
        List<SelectItem> selectItems = plainSelect.getSelectItems();

        // Check if the select clause is '*'
        if (selectItems.get(0).toString().equals("*")) {
            // Replace '*' with 'my_table.*'
            plainSelect.setSelectItems(Collections.singletonList(new AllColumns(new Table("my_table"))));
        }

        // Print the modified SQL statement
        System.out.println(plainSelect.toString());
    }
}