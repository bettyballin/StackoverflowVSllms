protected void Page_Load(object sender, EventArgs e)\n{\n    // Assuming your control ID is MyTextBox\n    MyTextBox.ValidateRequestMode = System.Web.UI.ValidateRequestMode.Disabled;\n}