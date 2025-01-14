import dns.resolver\n\n   def is_valid_domain(email):\n       domain = email.split('@')[1]\n       try:\n           mx_records = dns.resolver.resolve(domain, 'MX')\n           return len(mx_records) > 0\n       except dns.resolver.NoAnswer:\n           return False\n       except dns.resolver.NXDOMAIN:\n           return False\n       except Exception as e:\n           return False\n\n   email = "example@example.com"\n   print(is_valid_domain(email))