if exist FastImage.dll (\n    echo File was not deleted.\n    REM You can add code to stop IIS here\n    REM net stop w3svc\n) else (\n    echo File was deleted successfully.\n)