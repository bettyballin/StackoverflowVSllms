if (dtDepartments.Count > 0 && !dtDepartments[0].IsDBNull("job_department_id"))\n{\n    iDepartmentID = dtDepartments[0].job_department_id;\n}\nelse\n{\n    // handle the case where no data is returned\n}