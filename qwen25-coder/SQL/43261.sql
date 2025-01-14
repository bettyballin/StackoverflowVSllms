CREATE TABLE BranchDim (\n    branch_dim_id INT PRIMARY KEY,\n    branchNo VARCHAR(10),\n    bStreetAddress VARCHAR(255),\n    bCity VARCHAR(100)\n);\n\nCREATE TABLE LoanManagerDim (\n    loan_manager_dim_id INT PRIMARY KEY,\n    empNo VARCHAR(9),\n    empName VARCHAR(100),\n    phone VARCHAR(15),\n    branch_dim_id INT,\n    FOREIGN KEY (branch_dim_id) REFERENCES BranchDim(branch_dim_id)\n);\n\nCREATE TABLE CustomerDim (\n    customer_dim_id INT PRIMARY KEY,\n    custNo INT UNIQUE,\n    custName VARCHAR(100),\n    profession VARCHAR(100),\n    streetAddress VARCHAR(255),\n    city VARCHAR(100),\n    state VARCHAR(50)\n);\n\nCREATE TABLE AccountDim (\n    account_dim_id INT PRIMARY KEY,\n    accNo VARCHAR(15) UNIQUE,\n    accType VARCHAR(50),\n    balance DECIMAL(18, 2),\n    accDate DATE,\n    customer_dim_id INT,\n    FOREIGN KEY (customer_dim_id) REFERENCES CustomerDim(customer_dim_id)\n);\n\nCREATE TABLE DateDim (\n    date_dim_id INT PRIMARY KEY,\n    loan_date DATE UNIQUE,\n    year INT,\n    month INT\n);\n\n-- Fact Table\nCREATE TABLE LoanFact (\n    loan_amount DECIMAL(18, 2),\n    branch_dim_id INT,\n    loan_manager_dim_id INT,\n    customer_dim_id INT,\n    account_dim_id INT,\n    date_dim_id INT,\n    FOREIGN KEY (branch_dim_id) REFERENCES BranchDim(branch_dim_id),\n    FOREIGN KEY (loan_manager_dim_id) REFERENCES LoanManagerDim(loan_manager_dim_id),\n    FOREIGN KEY (customer_dim_id) REFERENCES CustomerDim(customer_dim_id),\n    FOREIGN KEY (account_dim_id) REFERENCES AccountDim(account_dim_id),\n    FOREIGN KEY (date_dim_id) REFERENCES DateDim(date_dim_id)\n);