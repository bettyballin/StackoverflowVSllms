CREATE TABLE accounts (\n    account_id INT PRIMARY KEY,\n    account_name VARCHAR(255) NOT NULL,\n    account_type ENUM('Asset', 'Liability', 'Equity', 'Revenue', 'Expense') NOT NULL\n);\n\nCREATE TABLE journal_entries (\n    entry_id INT PRIMARY KEY AUTO_INCREMENT,\n    account_id INT NOT NULL,\n    entry_date DATE NOT NULL,\n    description VARCHAR(255),\n    amount DECIMAL(15, 2) NOT NULL,\n    entry_type ENUM('Debit', 'Credit') NOT NULL,\n    FOREIGN KEY (account_id) REFERENCES accounts(account_id)\n);