ALTER TABLE usersmessages \nADD FOREIGN KEY (messageid) REFERENCES messages(messageid) \nON DELETE CASCADE;