// ChildControl.ascx.cs\npublic partial class ChildControl : System.Web.UI.UserControl\n{\n    // Define the delegate for the event\n    public delegate void EditEventHandler(object sender, EventArgs e);\n\n    // Define the event based on the delegate\n    public event EditEventHandler EditEvent;\n\n    protected void Page_Load(object sender, EventArgs e)\n    {\n    }\n\n    protected void EditButton_Click(object sender, EventArgs e)\n    {\n        // Raise the event\n        if (EditEvent != null)\n        {\n            EditEvent(this, e);\n        }\n    }\n}