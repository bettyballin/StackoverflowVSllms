protected override void OnVisibleChanged(EventArgs e)\n{\n    base.OnVisibleChanged(e);\n    if (this.Visible)\n    {\n        this.Hide();\n    }\n}