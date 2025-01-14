SELECT DISTINCT c.id, c.*\nFROM clients c\nJOIN invoices i ON c.id = i.client_id AND i.invoice_date BETWEEN 'START_OF_MONTH' AND 'END_OF_MONTH'\nUNION\nSELECT DISTINCT c.id, c.*\nFROM clients c\nJOIN deliveries d ON c.id = d.client_id AND d.delivery_date BETWEEN 'START_OF_MONTH' AND 'END_OF_MONTH';