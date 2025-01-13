// Basic retry logic with delay\n   for (int i = 0; i < maxRetries; i++) {\n       try {\n           using (SqlConnection conn = new SqlConnection(connectionString)) {\n               conn.Open();\n               break;\n           }\n       } catch (SqlException) when (i < maxRetries - 1) {\n           Thread.Sleep(delay);\n       } catch (SqlException ex) {\n           logger.LogError("Failed to connect to database after retries: {ErrorMessage}", ex.Message);\n       }\n   }