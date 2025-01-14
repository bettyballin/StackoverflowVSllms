function fetchWithETag() {\n        const eTag = localStorage.getItem('etag');\n        XMLHttpRequest.get('/data', {\n            headers: eTag ? { 'If-None-Match': eTag } : {}\n        }).then(response => {\n            if (response.status === 304) {\n                // Use cached data\n                const cachedData = getCachedData('data');\n                useData(cachedData);\n            } else {\n                // Update cache with new data\n                const data = response.data;\n                const newETag = response.headers['ETag'];\n                localStorage.setItem('etag', newETag);\n                cacheData('data', data);\n                useData(data);\n            }\n        });\n    }