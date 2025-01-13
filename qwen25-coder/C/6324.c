NTSTATUS OnFileCreate(\n    PFLT_CALLBACK_DATA Data,\n    PCFLT_RELATED_OBJECTS FltObjects,\n    PVOID *CompletionContext)\n{\n    UNREFERENCED_PARAMETER(FltObjects);\n    UNREFERENCED_PARAMETER(CompletionContext);\n\n    if(Data->Iopb->MajorFunction == IRP_MJ_CREATE) {\n        // Retrieve the process ID from the IO status block\n        PEPROCESS Process = IoGetCurrentProcess();\n        HANDLE ProcessId = PsGetProcessId(Process);\n        \n        UNICODE_STRING fileName;\n        RtlInitUnicodeString(&fileName, NULL);\n\n        // Get the file name from FltObjects->FileObject\n        FltGetFileNameInformation(Data->Iopb->TargetFileObject,\n                                 FLT_FILE_NAME_NORMALIZED | FLT_FILE_NAME_QUERY_DEFAULT, \n                                 &fileNameInfo);\n        if (fileNameInfo != NULL) {\n            FltParseFileNameInformation(fileNameInfo, &fileName);\n\n            // Log the information: ProcessId and fileName\n            DbgPrint("Process ID %p opened file %wZ\n", ProcessId, &fileName);\n\n            // Don't forget to free the name info after using it\n            FltReleaseFileNameInformation(fileNameInfo);\n        }\n    }\n\n    return STATUS_SUCCESS;\n}