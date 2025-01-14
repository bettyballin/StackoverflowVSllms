function checkUser() {\n    return new Promise((resolve, reject) => {\n        var request = new XMLHttpRequest();\n        var stu_id = document.getElementById("stu_id").value;\n        var dName = document.getElementById("dName").value;\n        var fileName = "check_user.php?dName=" + dName + "&stu_id=" + stu_id;\n        request.open("GET", fileName, true);\n        request.send(null);\n\n        request.onreadystatechange = function() {\n            if (request.readyState == 4) {\n                var resp = parseInt(request.responseText, 10);\n                if (resp === 1) {\n                    alert("The display name has already been taken.");\n                    resolve(false);\n                } else if (resp === 2) {\n                    alert("This student ID has already been registered");\n                    resolve(false);\n                } else if (resp === 0) {\n                    resolve(true);\n                } else {\n                    reject("Unexpected response");\n                }\n            }\n        }\n    });\n}\n\n// Usage\ncheckUser().then(status => {\n    if (status) {\n        // Code to execute if status is true\n        console.log("User can proceed");\n    } else {\n        // Code to execute if status is false\n        console.log("User cannot proceed");\n    }\n}).catch(error => {\n    console.error("Error:", error);\n});