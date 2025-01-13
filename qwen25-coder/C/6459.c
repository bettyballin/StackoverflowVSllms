const char *connectionString = "myserver.com:1521/myservicename";\nsword status;\nOCIEnv *envhp;\nOCIServer *srvhp;\nOCISession *authp;\nOCIDescribe *dschp;\nOCIError *errhp;\n\n// Initialize the environment handle, server handle, and error handle\nOCIInitialize(OCI_DEFAULT, NULL, NULL, NULL, NULL);\n OCIHandleAlloc(NULL, (dvoid **)&envhp, OCI_HTYPE_ENV, 0, 0); \nOCIHandleAlloc(envhp, (dvoid **)&srvhp, OCI_HTYPE_SERVER, 0, (dvoid **) 0);\nOCIHandleAlloc(envhp, (dvoid **)&errhp, OCI_HTYPE_ERROR, 0, (dvoid **) 0);\n\n// Create server context\nstatus = OCIServerAttach(srvhp, errhp, (OraText *) connectionString,\n                          STRLEN(connectionString), OCI_DEFAULT);\n\n// Initialize the service context handle and login\nOCIHandleAlloc(envhp, (dvoid **)&authp, OCI_HTYPE_SESSION, 0, (dvoid **) 0);\nOCILogon(envhp, errhp, &authp, \n         (OraText *)"username", STRLEN("username"),\n         (OraText *)"password", STRLEN("password"), \n         srvhp, OCI_DEFAULT);