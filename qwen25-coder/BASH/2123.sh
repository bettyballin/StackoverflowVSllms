# Define your service name and SQL Server service name\n$myServiceName = "YourServiceName"\n$sqlServerServiceName = "MSSQLSERVER" # Adjust this if you have a named instance, e.g., MSSQL$INSTANCENAME\n\n# Set the dependency of your service on SQL Server service\nNew-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\$myServiceName" -Name DependOnService -Value $sqlServerServiceName -PropertyType MultiString -Force