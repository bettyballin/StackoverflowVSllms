CString sqlCommand = "SELECT * FROM DOG WHERE DOG.NAME LIKE ?;";\nm_pAdoCommand->CommandText = _bstr_t(sqlCommand);\n\n// Prepare the parameter value with wildcards\nCString paramValue = "%bob%";\n\n// Append the parameter to the command\nm_pAdoCommand->Parameters->Append(\n    m_pAdoCommand->CreateParameter("p0", adVarChar, adParamInput, 25, _bstr_t(paramValue))\n);\n\n// Execute the command\nm_pAdoRecordset = m_pAdoCommand->Execute(NULL, NULL, adCmdText);