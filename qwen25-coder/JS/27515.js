async function getFileType(url) {\n    try {\n        const response = await fetch(url, { method: 'HEAD' });\n        if (!response.ok) {\n            throw new Error('Network response was not ok');\n        }\n\n        // For more reliable MIME type detection, you can also inspect the Content-Type header\n        const contentType = response.headers.get('Content-Type');\n        if (contentType.includes('image/jpeg')) {\n            return 'jpg';\n        } else if (contentType.includes('application/x-shockwave-flash')) {\n            return 'swf';\n        }\n\n        // If Content-Type is not reliable, you can fetch the actual bytes\n        const blob = await fetch(url).then(r => r.blob());\n        const arrayBuffer = await blob.arrayBuffer();\n        const byteArray = new Uint8Array(arrayBuffer);\n\n        // Check for JPG magic numbers: 255, 216 (FF D8)\n        if (byteArray[0] === 255 && byteArray[1] === 216) {\n            return 'jpg';\n        }\n\n        // Check for SWF magic numbers: 73 84 68 (IST) or 76 87 83\n        const isSWF = (\n            (byteArray[0] === 73 && byteArray[1] === 84 && byteArray[2] === 68) ||\n            (byteArray[0] === 76 && byteArray[1] === 87 && byteArray[2] === 83)\n        );\n        if (isSWF) {\n            return 'swf';\n        }\n\n        throw new Error('File type could not be determined');\n    } catch (error) {\n        console.error('Error:', error);\n    }\n}\n\n// Usage\ngetFileType('https://example.com/somefile')\n    .then(type => console.log(`Detected file type: ${type}`));