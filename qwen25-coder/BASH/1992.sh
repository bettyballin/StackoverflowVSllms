# In PowerShell, you can use this command to read the security events:\nGet-EventLog -LogName Security | Where { $_.InstanceID -eq 4657 } # Filter by Object Access Auditing Event ID