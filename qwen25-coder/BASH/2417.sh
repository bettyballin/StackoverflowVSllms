# Example for Windows Firewall (requires administrative privileges)\n   netsh advfirewall firewall add rule name="BlockUnauthorizedIP" dir=in action=block remoteip=<IP_ADDRESS>