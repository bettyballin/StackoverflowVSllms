$password = "yourPassword!@#";\n$filteredPassword = preg_replace('/[^\x20-\x7E]/', '', $password);\necho $filteredPassword;