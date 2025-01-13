CREATE TABLE suppliers (\n  supplier_id SERIAL PRIMARY KEY,\n  address_id INTEGER NOT NULL,\n  FOREIGN KEY (address_id) REFERENCES addresses(address_id)\n);\n\nCREATE TABLE purchase_orders (\n  po_id SERIAL PRIMARY KEY,\n  supplier_id INTEGER NOT NULL,\n  address_id INTEGER NOT NULL,\n  FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id),\n  FOREIGN KEY (address_id) REFERENCES addresses(address_id)\n);