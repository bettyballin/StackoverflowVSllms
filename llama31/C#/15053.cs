using (FileStream fs = new FileStream(Server.MapPath(GlobalVar.compathver), FileMode.Open, FileAccess.Read, FileShare.ReadWrite))\n{\n    // ... other code ...\n}