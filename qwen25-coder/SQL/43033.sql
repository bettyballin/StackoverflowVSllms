CREATE TABLE lab_results (\n      result_id NUMBER PRIMARY KEY,\n      test_id NUMBER,\n      patient_id NUMBER,\n      result_value VARCHAR2(100),\n      result_type VARCHAR2(50) -- e.g., 'single_value', 'waveform'\n  );