-- Enable Service Broker on your database\nALTER DATABASE YourDatabase SET ENABLE_BROKER;\n\n-- Create a queue\nCREATE QUEUE AuditQueue;\n\n-- Create a service\nCREATE SERVICE AuditService\n    ON QUEUE AuditQueue\n    ([DEFAULT]);