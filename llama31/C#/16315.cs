protected override void OnPreRender(EventArgs e)\n{\n    base.OnPreRender(e);\n\n    // Enable sorting, filtering, and paging\n    this.AllowSorting = true;\n    this.AllowFiltering = true;\n    this.AllowPaging = true;\n\n    // Set up the sorting and filtering controls\n    this.SortExpression = "YourObjectProperty";\n    this.FilterExpression = "YourObjectProperty";\n}