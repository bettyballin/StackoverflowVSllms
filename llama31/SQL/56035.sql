CREATE TABLE signal_header (\n  signal_id NUMBER PRIMARY KEY,\n  start_time DATE,\n  sample_rate NUMBER,\n  units VARCHAR2(20),\n  -- other metadata columns\n);\n\nCREATE TABLE raw_signal_value (\n  signal_id NUMBER,\n  offset_index NUMBER,\n  value NUMBER,\n  CONSTRAINT fk_signal_id FOREIGN KEY (signal_id) REFERENCES signal_header(signal_id)\n);