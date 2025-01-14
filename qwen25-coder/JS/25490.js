function sleep(ms) {\n    return new Promise(resolve => setTimeout(resolve, ms));\n}\n\nasync function run() {\n    var chkResult = Validation();\n    \n    // Wait for 10 seconds (10,000 milliseconds)\n    await sleep(10000);\n    \n    document.getElementById('abc').innerHTML = chkResult;\n}\n\nrun();