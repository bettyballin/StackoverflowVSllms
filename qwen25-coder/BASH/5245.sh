@echo off\n:: Set ORACLE_HOME for 32-bit client\nset ORACLE_HOME=C:\oracle\Client_32bit\n\n:: Update PATH to use 32-bit client binaries\nset PATH=%ORACLE_HOME%\bin;%PATH%\n\n:: Launch RapidSQL or any other 32-bit application that needs access to Oracle\nstart "" "C:\Program Files (x86)\Embarcadero\Rapid SQL\dbexpert.exe"