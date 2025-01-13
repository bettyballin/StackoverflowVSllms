public partial class YourUserControl : UserControl\n{\n    public event EventHandler<LookupEventArgs> LookupEntries;\n\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        // Client-side script to call the handler\n        string script = @"\n            $.ajax({\n                type: ""GET"",\n                url: ""/YourHandler.ashx"",\n                data: {{ input: ""your_input"" }},\n                dataType: ""json"",\n                success: function(data) {\n                    // Handle the result\n                }\n            });\n        ";\n\n        ScriptManager.RegisterStartupScript(this, this.GetType(), "Lookup", script, true);\n    }\n\n    public void RaiseLookupEntries(string input)\n    {\n        LookupEntries?.Invoke(this, new LookupEventArgs(input));\n    }\n}\n\npublic class LookupEventArgs : EventArgs\n{\n    public string Input { get; set; }\n\n    public LookupEventArgs(string input)\n    {\n        Input = input;\n    }\n}