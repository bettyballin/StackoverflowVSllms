@echo off\nnet use z: \\server\share /persistent:no\nstart "My Service" "C:\Path\To\Service.exe"