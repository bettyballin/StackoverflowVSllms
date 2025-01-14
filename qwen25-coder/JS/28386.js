function uploadFile(file) {\n    const chunkSize = 1024 * 1024; // 1MB chunks\n    let start = 0;\n    \n    function uploadChunk() {\n        const end = Math.min(start + chunkSize, file.size);\n        const blob = file.slice(start, end);\n\n        const formData = new FormData();\n        formData.append('file', blob);\n        formData.append('filename', file.name);\n        formData.append('start', start);\n        formData.append('end', end);\n        \n        fetch('/upload', {\n            method: 'POST',\n            body: formData\n        }).then(response => {\n            if (!response.ok) throw new Error("Network response was not ok");\n            return response.json();\n        }).then(data => {\n            console.log('Chunk uploaded:', data);\n            if (end < file.size) {\n                start = end;\n                uploadChunk();\n            } else {\n                console.log('Upload complete');\n            }\n        }).catch(error => {\n            console.error('Error uploading chunk:', error);\n        });\n    }\n\n    uploadChunk();\n}