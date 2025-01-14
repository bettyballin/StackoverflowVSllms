CREATE TABLE ProductTasks (\n    ProductID INT,\n    TaskID INT,\n    TaskOrder INT,\n    PRIMARY KEY (ProductID, TaskID),\n    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),\n    FOREIGN KEY (TaskID) REFERENCES Tasks(TaskID),\n    UNIQUE KEY unique_product_taskorder (ProductID, TaskOrder)\n);