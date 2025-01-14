import dns.resolver\n\ndomain = "example.com"\ntry:\n    answers = dns.resolver.resolve(domain, 'MX')\n    for rdata in answers:\n        print(f"Mail server: {rdata.exchange}")\nexcept Exception as e:\n    print("No MX records found:", e)