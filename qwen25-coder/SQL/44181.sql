SET NOCOUNT ON;\n\nDECLARE @cmd VARCHAR(100)\nDECLARE @output TABLE (line VARCHAR(8000))\nDECLARE @hostname VARCHAR(50) = 'stackoverflow.com'\nDECLARE @resolved_ip VARCHAR(50)\n\n-- Construct the nslookup command\nSELECT @cmd = 'nslookup ' + @hostname\n\n-- Insert the output of the command into a table\nINSERT INTO @output EXEC xp_cmdshell @cmd\n\n-- Extract the IP address from the output\nSELECT TOP 1 @resolved_ip = SUBSTRING(line, CHARINDEX(':', line) + 2, LEN(line))\nFROM @output\nWHERE line LIKE '%Non-authoritative answer:%[^:]: %'\n\n-- Output the resolved IP address\nPRINT 'Resolved IP: ' + ISNULL(@resolved_ip, 'Not found')