protected void UpdatePanel1_Updated(object sender, EventArgs e)\n{\n    ScriptManager.GetCurrent(this).RegisterStartupScript(this, typeof(string), "scrollable", @"\n        $(function() {\n            $(""div.scrollable"").scrollable({\n                size: 3\n            });\n        });\n    ", true);\n}