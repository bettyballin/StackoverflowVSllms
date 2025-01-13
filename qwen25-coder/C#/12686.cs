// Assuming you are using ASP.NET Web Forms with AJAX Toolkit\nprotected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Common settings for FilteredTextBoxExtender\n        filteredTextBoxExtender.TargetControlID = TextBox1.ID;\n        SetFilterRules(filteredTextBoxExtender);\n\n        // Add all textboxes to a list or array\n        var textBoxes = new List<TextBox> { TextBox1, TextBox2, TextBox3, TextBox4, TextBox5, TextBox6, TextBox7, TextBox8 };\n        \n        foreach (var textBox in textBoxes)\n        {\n            textBox.Attributes.Add("onBlur", "ChangeFilteredTarget(this.id);");\n        }\n    }\n}\n\nprotected void SetFilterRules(FilteredTextBoxExtender extender)\n{\n    // Configure the rules for your filter here\n    extender.FilterType = FilterTypes.Custom;\n    extender.ValidChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";\n}\n\n// JavaScript to trigger server-side changes on target (Note: actual reassignment can't be done directly from client-side in this component)\n<script type="text/javascript">\n    function ChangeFilteredTarget(textBoxId) {\n        // Trigger postback to change the TargetControlID of FilteredTextBoxExtender\n        __doPostBack('<%= UniqueID %>', 'ChangeFilter-' + textBoxId);\n    }\n</script>\n\nprotected void Page_LoadComplete(object sender, EventArgs e)\n{\n    if (Request["__EVENTARGUMENT"] != null && Request["__EVENTARGUMENT"].StartsWith("ChangeFilter-"))\n    {\n        string targetControlId = Request["__EVENTARGUMENT"].Substring("ChangeFilter-".Length);\n        filteredTextBoxExtender.TargetControlID = targetControlId;\n    }\n}