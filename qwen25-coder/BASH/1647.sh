cmd /c echo using System.Reflection;^[echo [assembly: BuildDateAttribute("%date% %time%")]; > $(ProjectDir)Properties\AssemblyInfo.BuildDate.cs