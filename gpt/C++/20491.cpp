void WriteLastDirectory(const String& lastDirectory) {\n       TRegistry* reg = new TRegistry(KEY_WRITE);\n       try {\n           reg->RootKey = HKEY_CURRENT_USER;\n           if (reg->OpenKey("\\Software\\YourAppName\\Options", true)) {\n               reg->WriteString("Last Directory", lastDirectory);\n               reg->CloseKey();\n           }\n       } __finally {\n           delete reg;\n       }\n   }