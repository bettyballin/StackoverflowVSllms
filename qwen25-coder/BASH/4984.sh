curl https://packages.microsoft.com/keys/microsoft.asc | sudo apt-key add -\ncurl https://packages.microsoft.com/config/ubuntu/$(lsb_release -rs)/prod.list | sudo tee /etc/apt/sources.list.d/msprod.list\nsudo apt-get update \nsudo ACCEPT_EULA=Y apt-get install -y mssql-tools unixodbc-dev