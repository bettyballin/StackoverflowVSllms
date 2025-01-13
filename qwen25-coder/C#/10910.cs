protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        string script = @"\n            Sys.CultureInfo.prototype._getAbbrMonthIndex = function(value) {\n                if (!this._upperAbbrMonths) {\n                    this._upperAbbrMonths = this._toUpperArray(this.dateTimeFormat.AbbreviatedMonthNames);\n                }\n                return Array.indexOf(this._upperAbbrMonths, this._toUpper(value));\n            };";\n\n        ClientScript.RegisterStartupScript(this.GetType(), "fixDateTimeFormat", script, true);\n    }\n}