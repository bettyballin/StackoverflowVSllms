// Function to get data from server\nfunction fetchDataFromServer(url) {\n    return fetch(url)\n        .then(response => response.text())\n        .then(data => ({\n            timestamp: Date.now(),\n            data: data\n        }));\n}\n\n// Function to save data to local storage with a version or timestamp\nfunction cacheData(key, data) {\n    localStorage.setItem(key, JSON.stringify(data));\n}\n\n// Function to retrieve data from local storage\nfunction getCachedData(key, maxAge = 3600000) { // default cache max age: 1 hour\n    const cachedItem = localStorage.getItem(key);\n    if (cachedItem) {\n        const item = JSON.parse(cachedItem);\n        if ((Date.now() - item.timestamp) < maxAge) {\n            return Promise.resolve(item.data);\n        }\n    }\n    // If no valid cache, fetch new data from server\n    return fetchDataFromServer(url)\n        .then(data => {\n            cacheData(key, data);\n            return data.data;\n        });\n}\n\nconst url = 'http://your-server/api/data';\ngetCachedData('dataKey')\n    .then(data => console.log('Received data:', data))\n    .catch(error => console.error('Failed to fetch data:', error));