function displaymessage()\n        {\n            try\n            {\n                var filename;\n                var class1 = document.getElementById("Class1");\n                filename = class1.SaveClipboardToImage();\n\n                alert(filename);\n            }\n            catch(e)\n            {\n                alert(e.message);\n            }                       \n        }