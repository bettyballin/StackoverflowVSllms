Page_Load()\n   {\n     if (!User.IsInRole("Managers"))\n     {\n       AddAccount.Visible = false;\n     }\n   }\n\n   AddAccount_OnClick()\n   {\n     if (!User.IsInRole("Managers"))\n     {\n       // Optionally, log and provide user feedback\n       return;\n     }\n     Account.Add(...);\n   }