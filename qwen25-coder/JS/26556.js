// Create a script file, e.g., ConvertToBase64.js and run it using cscript.exe\nvar fso = new ActiveXObject("Scripting.FileSystemObject");\nvar inFilePath = "C:\\path\\to\\your\\file.bin";\nvar inFile = fso.OpenTextFile(inFilePath, 1);\nvar BinaryStream = new ActiveXObject("ADODB.Stream");\n\nBinaryStream.Type = 1; // adTypeBinary\nBinaryStream.LoadFromFile(inFilePath);\n\nvar Binary = BinaryStream.Read();\n\nvar inputByteArray = [];\nfor (var i = 0; i < Binary.length; ++i) {\n    inputByteArray[i] = Binary.charCodeAt(i);\n}\n\nvar Base64String = EncodeToBase64(inputByteArray);\nWScript.Echo(Base64String);\n\n\nfunction EncodeToBase64(bytesInput)\n{\n    var encodings = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";\n    var result = "";\n    var i;\n    if (bytesInput.length == 0)\n        return "";\n\n    for(i=0; i<bytesInput.length-2; i += 3) {\n        result += encodings.charAt((bytesInput[i] & 0xff) >> 2);\n        result += encodings.charAt(((bytesInput[i] & 0x03) << 4) + ((bytesInput[i+1] & 0xf0) >> 4));\n        result += encodings.charAt(((bytesInput[i+1] & 0x0f) << 2) + ((bytesInput[i+2] & 0xc0) >> 6));\n        result += encodings.charAt((bytesInput[i+2] & 0x3f) >> 0);\n    }\n\n    if(bytesInput.length-i == 1) {\n        result += encodings.charAt((bytesInput[i] & 0xff) >> 2);\n        result += encodings.charAt(((bytesInput[i] & 0x03) << 4));\n        result += "==";\n    } else if(bytesInput.length-i == 2) {\n        result += encodings.charAt((bytesInput[i] & 0xff) >> 2);\n        result += encodings.charAt(((bytesInput[i] & 0x03) << 4) + ((bytesInput[i+1] & 0xf0) >> 4));\n        result += encodings.charAt(((bytesInput[i+1] & 0x0f) << 2));\n        result += "=";\n    }\n    return result;\n}