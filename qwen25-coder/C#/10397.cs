public class CustomImage : System.Web.UI.WebControls.Image\n{\n    protected override string GetUniqueIDRelativeTo(System.Web.UI.Control control)\n    {\n        // Return a custom unique ID\n        return this.ID;\n    }\n}