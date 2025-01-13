# Check the Application Pool settings for managed runtime version\nGet-ChildItem IIS:\AppPools | ForEach-Object {\n    $appPool = $_.Name\n    $runtime = (Get-ItemProperty IIS:\AppPools\$appPool).managedRuntimeVersion\n    Write-Host "Application Pool: $appPool, Managed Runtime Version: $runtime"\n}\n\n# Check the site bindings for port configuration\nGet-ChildItem IIS:\Sites | ForEach-Object {\n    $site = $_.Name\n    $bindings = (Get-ItemProperty IIS:\Sites\$site).Bindings.Collection.BindingInformation -join ", "\n    Write-Host "Site: $site, Bindings: $bindings"\n}