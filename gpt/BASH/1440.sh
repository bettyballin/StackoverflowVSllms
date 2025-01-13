$projects = Get-ChildItem -Recurse -Include *.csproj\n   $oldVersion = "1.0.0.0"\n   $newVersion = "2.0.0.0"\n\n   foreach ($project in $projects) {\n       (Get-Content $project.PSPath) -replace $oldVersion, $newVersion | Set-Content $project.PSPath\n   }