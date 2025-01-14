// Example of using Fetch API with chunked upload\nasync function uploadFile(file, url) {\n    const chunkSize = 10 * 1024 * 1024; // 10MB chunks\n    let offset = 0;\n    const totalChunks = Math.ceil(file.size / chunkSize);\n\n    while (offset < file.size) {\n        const blobSlice = File.prototype.slice || File.prototype.mozSlice || File.prototype.webkitSlice,\n              chunk = blobSlice.call(file, offset, offset + chunkSize),\n              fd = new FormData();\n        \n        fd.append('chunk', chunk);\n        fd.append('filename', file.name);\n        fd.append('totalChunks', totalChunks);\n        fd.append('currentChunk', Math.floor(offset / chunkSize) + 1);\n\n        await fetch(url, {\n            method: 'POST',\n            body: fd,\n            headers: {\n                'X-Your-Secret-Key': 'yourSecretKeyHere'\n            }\n        });\n\n        offset += chunkSize;\n    }\n}