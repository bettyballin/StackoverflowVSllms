var actCtx = WScript.CreateObject("Microsoft.Windows.ActCtx");\nactCtx.Manifest = "myregfree.manifest";\nvar obj =  actCtx.CreateObject("MyObj");   