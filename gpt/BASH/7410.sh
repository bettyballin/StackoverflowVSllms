wget https://packages.microsoft.com/config/ubuntu/20.04/packages-microsoft-prod.deb -O packages-microsoft-prod.deb\n   sudo dpkg -i packages-microsoft-prod.deb\n   sudo apt-get update\n   sudo apt-get install -y apt-transport-https\n   sudo apt-get update\n   sudo apt-get install -y dotnet-sdk-5.0  # or the latest versio