// Assume these are your two asynchronous functions\nfunction ajaxCall(callback) {\n  // Simulating an AJAX call\n  setTimeout(() => {\n    callback("AJAX response");\n  }, 2000);\n}\n\nfunction otherCode(callback) {\n  // Simulating some other code running\n  setTimeout(() => {\n    callback("Other code response");\n  }, 3000);\n}\n\n// Create promises for both functions\nconst ajaxPromise = new Promise((resolve) => {\n  ajaxCall((response) => {\n    resolve(response);\n  });\n});\n\nconst otherCodePromise = new Promise((resolve) => {\n  otherCode((response) => {\n    resolve(response);\n  });\n});\n\n// Use Promise.all to wait for both promises to resolve\nPromise.all([ajaxPromise, otherCodePromise]).then((responses) => {\n  // Call your third function with the responses\n  thirdFunction(responses[0], responses[1]);\n});\n\nfunction thirdFunction(ajaxResponse, otherCodeResponse) {\n  console.log("Both done!", ajaxResponse, otherCodeResponse);\n}