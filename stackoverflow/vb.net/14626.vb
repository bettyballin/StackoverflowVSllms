enter code here\n    For Each DNSZone As ManagementObject In mgrZones            \n         DNSZone("zonetype") = 1 'sets it to primary\n         DNSZone.Put()\n   Next