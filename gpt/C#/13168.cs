protected void Page_Load(object sender, EventArgs e)\n{\n    if (IsPostBack)\n    {\n        string eventTarget = this.Request["__EVENTTARGET"];\n        if (eventTarget == DropDownList1.UniqueID)\n        {\n            DropDownList1_SelectedIndexChanged(DropDownList1, EventArgs.Empty);\n        }\n    }\n}\n\nprotected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)\n{\n    // Your logic here\n}