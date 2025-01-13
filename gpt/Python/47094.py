import dns.zone\n    from dns.exception import DNSException\n    from dns.rdataclass import IN\n    from dns.rdatatype import SOA\n\n    def parse_zone_file(zone_file_path):\n        try:\n            zone = dns.zone.from_file(zone_file_path, relativize=False)\n            zone_dict = {}\n\n            for name, node in zone.nodes.items():\n                rdatasets = node.rdatasets\n                for rdataset in rdatasets:\n                    for rdata in rdataset:\n                        record_name = str(name)\n                        record_type = dns.rdatatype.to_text(rdataset.rdtype)\n                        record_data = rdata.to_text()\n                        if record_name not in zone_dict:\n                            zone_dict[record_name] = []\n                        zone_dict[record_name].append({\n                            'type': record_type,\n                            'data': record_data\n                        })\n\n            return zone_dict\n\n        except DNSException as e:\n            print(f"Error parsing zone file: {e}")\n            return None\n\n    # Usage example\n    zone_file_path = 'path_to_your_zone_file.zone'\n    zone_data = parse_zone_file(zone_file_path)\n    if zone_data:\n        for record_name, records in zone_data.items():\n            print(f"{record_name}:")\n            for record in records:\n                print(f"  Type: {record['type']}, Data: {record['data']}")