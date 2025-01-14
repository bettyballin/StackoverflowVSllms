from urllib.parse import urlparse\n\ndef get_domain(url):\n    parsed_url = urlparse(url)\n    domain = parsed_url.netloc\n    if domain.startswith('www.'):\n        domain = domain[4:]\n    return domain\n\n# Example usage\nprint(get_domain("http://google.com/dhasjkdas/sadsdds/sdda/sdads.html"))  # Output: google.com\nprint(get_domain("http://www.google.com/dhasjkdas/sadsdds/sdda/sdads.html"))  # Output: google.com\nprint(get_domain("http://google.co.uk/dhasjkdas/sadsdds/sdda/sdads.html"))  # Output: google.co.uk