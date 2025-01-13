// Define an ACO for the payroll resource\n$payrollAco = new Aco('payroll');\n\n// Define the ACL for the payroll ACO\n$payrollAcl = new Acl($payrollAco);\n$payrollAcl->allow('admin'); // Allow admin group to access payroll\n$payrollAcl->deny('employee'); // Deny employee group access to payroll\n\n// When a user requests access to payroll\n$user = new User('john', 'employee');\nif ($payrollAcl->isAllowed($user)) {\n    // Grant access to payroll\n} else {\n    // Deny access to payroll\n}