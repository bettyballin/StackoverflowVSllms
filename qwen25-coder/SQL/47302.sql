CREATE TABLE products (\n    product_id NUMBER PRIMARY KEY,\n    origin_code VARCHAR2(3),\n    date_part DATE,\n    type_code VARCHAR2(2),\n    sequence_number NUMBER,\n    composite_number VARCHAR2(50) GENERATED ALWAYS AS (\n        origin_code || '-' || TO_CHAR(date_part, 'YYMMDD') || '-' || type_code || '-' || LPAD(sequence_number, 4, '0')\n    ) VIRTUAL\n);