-- List of message types\nSELECT * FROM sys.service_message_types;\n\n-- List of contracts\nSELECT * FROM sys.service_contracts;\n\n-- List of services\nSELECT * FROM sys.services;\n\n-- List of queues\nSELECT * FROM sys.service_queues;\n\n-- List of message types used by contracts\nSELECT * FROM sys.service_contract_message_usages;\n\n-- List of messages in the transmission queue\nSELECT * FROM sys.transmission_queue;