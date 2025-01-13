string str = @"Sys.CultureInfo.prototype._getAbbrMonthIndex = function(value) { \n    if (!this._upperAbbrMonths) { \n        this._upperAbbrMonths = this._toUpperArray(this.dateTimeFormat.AbbreviatedMonthNames);\n    }\n    return Array.indexOf(this._upperAbbrMonths, this._toUpper(value));\n };";\n\nif(!ClientScriptManager.IsStartupScriptRegistered("MyScript"){\n  ClientScriptManager.RegisterStartupScript(this.GetType(), "MyScript", str, true)\n}