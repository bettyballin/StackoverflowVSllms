# SQL Server Database Engine\niptables -A INPUT -p tcp --dport 1433 -j ACCEPT\n\n# SQL Server Browser\niptables -A INPUT -p udp --dport 1434 -j ACCEPT\n\n# SQL Server Reporting Services (assuming default port 80)\niptables -A INPUT -p tcp --dport 80 -j ACCEPT\n\n# SQL Server Analysis Services\niptables -A INPUT -p tcp --dport 2383 -j ACCEPT