# Open PowerShell as an Administrator and install Windows Server Backup feature\n      Install-WindowsFeature -Name Windows-Server-Backup\n\n      # Schedule a daily backup using Windows Server Backup\n      wbadmin enable backup -addtarget:D: -schedule:00:00 -include:C: -allCritical -quiet