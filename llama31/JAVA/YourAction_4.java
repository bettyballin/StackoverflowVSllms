import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionContext;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.MappingDispatchAction;

public class YourAction_4_4 extends MappingDispatchAction {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        // Get the SearchForm from the session scope
        ActionContext context = ActionContext.getContext();
        HttpSession session = context.getSession();
        SearchForm searchForm = (SearchForm) session.getAttribute("SearchForm");

        // If the SearchForm is not in the session scope, create a new instance
        if (searchForm == null) {
            searchForm = new SearchForm();
            // Populate the basic search info
            // ...
        }

        // Use the SearchForm to generate the search results column
        // ...

        return mapping.findForward("success");
    }

    public static void main(String[] args) {
    }
}