import java.lang.String;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.commons.beanutils.FormUtils;
import org.apache.struts.Globals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class YourAction_1 extends MappingDispatchAction {
    public ActionForward createElementDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //... your code ...//

        ElementForm elementForm = (ElementForm)form;
        SearchForm searchForm = (SearchForm) FormUtils.getForm(request, "searchForm", new SearchForm(), false);

        //... use searchForm as required...//
    }

    public static void main(String[] args) {
    }
}