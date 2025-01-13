# Prevent the server from sleeping by modifying power plan settings\n$powerPlanGuid = (Get-WmiObject -Class Win32_PowerPlan | Where-Object { $_.ElementName -eq "High performance" }).InstanceID.Replace("Microsoft Windows Management Instrumentation\","")\n$policyArray = @{\n    "#AllowStandby"         = ([byte[]]@(0))\n    "#HibernateIdleTimeout" = ([byte[]]([math]::pow(2, 31) - 1))\n    "ACSettingIndexValue"   = ([byte[]]@([math]::pow(2, 31) - 1))\n}\nforeach ($key in $policyArray.Keys) {\n    powercfg /setvalueindex $powerPlanGuid SUB_NONE $key $policyArray[$key]\n}