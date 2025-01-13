fetch('https://example.com/api', {\n    method: 'POST',\n    headers: {\n        'Content-Type': 'application/json',\n        // Add other headers as needed\n    },\n    body: JSON.stringify({\n        key1: 'value1',\n        key2: 'value2'\n    })\n})\n.then(response => {\n    if (response.ok) {\n        return response.json(); // or response.text(), response.blob(), etc.\n    }\n    throw new Error('Network response was not ok');\n})\n.then(data => {\n    console.log(data); // Handle the response data here\n})\n.catch(error => {\n    console.error('There was a problem with the fetch operation:', error);\n});