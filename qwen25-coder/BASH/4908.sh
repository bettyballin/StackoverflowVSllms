iisreset /stop\n   del %windir%\Microsoft.NET\Framework\vX.X.XXXX\Temporary ASP.NET Files\*.* /S /Q\n   del %windir%\Microsoft.NET\Framework64\vX.X.XXXX\Temporary ASP.NET Files\*.* /S /Q\n   iisreset /start