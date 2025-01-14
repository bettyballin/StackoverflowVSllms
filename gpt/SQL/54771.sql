-- Variable to hold the generated runID\nVARIABLE runId NUMBER;\n\n-- Insert into Runs table and capture the generated runID\nINSERT INTO Runs (Model_Type, Time)\nVALUES ('model1', TO_DATE('01-01-2009 14:47:00', 'MM-DD-YYYY HH24:MI:SS'))\nRETURNING runID INTO :runId;\n\n-- Insert into Run_Values table using the captured runID\nINSERT INTO Run_Values (run_id, Value) VALUES (:runId, 1.0);\n-- Add more insert statements as needed\nINSERT INTO Run_Values (run_id, Value) VALUES (:runId, 2.0);\nINSERT INTO Run_Values (run_id, Value) VALUES (:runId, 3.0);\n\n-- You can commit the transaction if needed\nCOMMIT;