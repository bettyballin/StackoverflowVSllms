function CheckForUserName(sender, args) {\n  args.IsValid = true;\n\n  var url = "/somepage.aspx";\n\n  MakeCall(url, function(txt) {\n    if (txt == "false") {\n      args.IsValid = false;\n    }\n    // Call the validation callback function here\n    args.callback();\n  });\n}