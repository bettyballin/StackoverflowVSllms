@echo off\nREM Map network drive\nnet use K: \\remote-machine\dir /user:username password\n\nREM Navigate to the engine's directory if needed\ncd /d "C:\path\to\engine"\n\nREM Start the engine\njava -jar engine.jar