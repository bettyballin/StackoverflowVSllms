import dns.resolver\n\ndomain = 'example.com'\ntry:\n    result = dns.resolver.resolve(domain, 'A')\n    for ipval in result:\n        print(f'IP: {ipval.to_text()}')\nexcept dns.resolver.NXDOMAIN:\n    print('Domain does not exist.')\nexcept dns.resolver.Timeout:\n    print('Query timed out.')\nexcept dns.resolver.NoAnswer:\n    print('No answer for the query.')