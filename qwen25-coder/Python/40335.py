import re\n\ndef parse_zone_file(file_path):\n    # Regular expression for matching standard DNS records\n    record_regex = re.compile(r'(?P<name>\S+)\s+(?P<ttl>\d+)?\s+(?P<class>IN)\s+(?P<type>A|AAAA|CNAME|MX|TXT|NS)\s+(?P<rdata>.*)')\n\n    zone_records = []\n\n    with open(file_path, 'r') as file:\n        for line in file:\n            # Ignore comments and empty lines\n            line = line.strip()\n            if not line or line.startswith(';'):\n                continue\n\n            match = record_regex.match(line)\n            if match:\n                record = match.groupdict()\n                zone_records.append(record)\n\n    return zone_records\n\n# Example usage\nzone_file_path = 'example.zone'\nparsed_zone = parse_zone_file(zone_file_path)\nprint(parsed_zone)