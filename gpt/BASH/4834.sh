# Ensure c:\WINDOWS\TEMP exists and has correct permissions\nicacls c:\WINDOWS\TEMP /grant "NETWORK SERVICE":(OI)(CI)F\nicacls c:\WINDOWS\TEMP /grant "SYSTEM":(OI)(CI)F\n\n# Check and set environment variables TMP and TEMP\nsetx TMP c:\WINDOWS\TEMP\nsetx TEMP c:\WINDOWS\TEMP\n\n# Re-register ASP.NET with IIS\n%windir%\Microsoft.NET\Framework64\v2.0.50727\aspnet_regiis.exe -i\n\n# Check disk space and ensure path lengths are reasonable