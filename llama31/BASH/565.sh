# Install Wireshark on your web server\nsudo apt-get install wireshark\n\n# Capture network traffic on the interface used to connect to SQL Server\nsudo wireshark -i <interface_name> -f "tcp port 1433"