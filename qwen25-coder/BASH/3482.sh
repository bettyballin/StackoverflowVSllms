sudo docker pull mcr.microsoft.com/mssql/server:2022-latest\n   sudo docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=YourStrong!Passw0rd" \\n      --name sqlserver -p 1433:1433 \\n      -v /path/on/host:/var/opt/mssql/data \\n      -d mcr.microsoft.com/mssql/server:2022-latest