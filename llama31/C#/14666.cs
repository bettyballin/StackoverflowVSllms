if (Page.IsValid == false)\n{\n    ClientScript.RegisterStartupScript(this.GetType(), "expandDiv", "$('#divChangePassword').slideDown();", true);\n}