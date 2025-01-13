# Function to get the current security settings for a specific URL\nfunction Get-IESecurityZone {\n    param (\n        [string]$Url = "http://example.com"\n    )\n\n    # Define the registry paths for different zones\n    $zones = @{\n        0 = "My Computer";\n        1 = "Local Intranet Zone";\n        2 = "Trusted sites Zone";\n        3 = "Internet Zone";\n        4 = "Restricted Sites Zone"\n    }\n\n    # Retrieve the zone ID for the URL\n    $urlZoneId = (Get-ItemProperty -Path "Registry::HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ZoneMap\Url To Zone Mapping\$Url" -Name "*")."*"\n\n    if ($zones.ContainsKey($urlZoneId)) {\n        Write-Output "The URL $Url is classified in the $($zones[$urlZoneId])."\n        \n        # Retrieve the security settings for the determined zone\n        $zoneSettings = Get-ItemProperty -Path "Registry::HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\Zones\$urlZoneId"\n\n        # Check specific settings like ActiveX controls\n        if ($zoneSettings.'1200' -eq 3) {\n            Write-Output "ActiveX controls and plug-ins marked as potentially dangerous are disabled."\n        } elseif ($zoneSettings.'1200' -eq 2) {\n            Write-Output "Initial and script download of certain ActiveX controls or plug-ins is allowed."\n        } else {\n            Write-Output "ActiveX controls are enabled to some degree."\n        }\n    } else {\n        Write-Output "The URL $Url does not have a specific security zone classification."\n    }\n}\n\n# Example usage\nGet-IESecurityZone -Url "http://your-site.com"