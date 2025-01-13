protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Bind your data to the ChecklistRepeater here\n        // Example:\n        ChecklistRepeater.DataSource = GetChecklistItems();\n        ChecklistRepeater.DataBind();\n    }\n}\n\nprotected void BtnDetails_Click(object sender, EventArgs e)\n{\n    Button btn = (Button)sender;\n    string itemID = btn.CommandArgument;\n\n    // Fetch details based on itemID\n    var itemDetails = GetItemDetails(itemID);\n    \n    // Set the labels in the modal panel\n    LabelID.Text = itemDetails.ID;\n    LabelName.Text = itemDetails.Name;\n\n    // Show the popup\n    ModalPopupExtender1.Show();\n}\n\nprotected void BtnClose_Click(object sender, EventArgs e)\n{\n    // Optionally close the popup if needed. It usually closes itself.\n}