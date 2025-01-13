import bind9\n\n# Create a bind9 client object\nclient = bind9.Client('dns.example.com', 'username', 'password')\n\n# Create a new zone\nzone = bind9.Zone('example.com', 'master', ['ns1.example.com', 'ns2.example.com'])\n\n# Add the zone to the DNS server\nclient.add_zone(zone)