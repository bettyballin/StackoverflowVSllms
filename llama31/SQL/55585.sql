CREATE UNIQUE INDEX idx_serial_number ON stock_items (serial_number) WHERE serial_number IS NOT NULL;