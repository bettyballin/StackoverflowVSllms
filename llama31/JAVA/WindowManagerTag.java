import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WindowManagerTag extends SimpleTagSupport {
  private String id;
  private int rows;
  private int columns;
  private List<Widget> widgets = new ArrayList<>();

  @Override
  public void doTag() throws JspException, IOException {
    JspWriter out = getJspContext().getOut();
    out.println("<div id='" + id + "' class='window-manager'>");
    for (Widget widget : widgets) {
      out.println("<div id='" + widget.getId() + "' class='widget' style='grid-row: " + widget.getRow() + "; grid-column: " + widget.getColumn() + "; grid-span: " + widget.getSpan() + ";'>");
      out.println(widget.getContent());
      out.println("</div>");
    }
    out.println("</div>");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getRows() {
    return rows;
  }

  public void setRows(int rows) {
    this.rows = rows;
  }

  public int getColumns() {
    return columns;
  }

  public void setColumns(int columns) {
    this.columns = columns;
  }

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }
}

class Widget {
  private String id;
  private int row;
  private int column;
  private int span;
  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public int getSpan() {
    return span;
  }

  public void setSpan(int span) {
    this.span = span;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public static void main(String[] args) {
  }
}