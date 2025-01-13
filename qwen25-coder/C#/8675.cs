public class TextField : TextBox\n{\n    public bool Required { get; set; }\n    private RequiredFieldValidator _validator;\n\n    protected override void CreateChildControls()\n    {\n        base.CreateChildControls();\n        \n        if (Required)\n        {\n            _validator = new RequiredFieldValidator();\n            _validator.ControlToValidate = this.ID;\n            Controls.Add(_validator);\n            \n            // Add the validator to the page's validators collection\n            Page.Validators.Add(_validator);\n        }\n    }\n\n    public override void Render(HtmlTextWriter tw)\n    {\n        base.Render(tw);\n\n        if (_validator != null)\n        {\n            _validator.RenderControl(tw);\n        }\n    }\n}