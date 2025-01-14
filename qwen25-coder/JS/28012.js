import axios from 'axios';\nimport React, { useEffect, useState } from 'react';\n\nfunction DataFetcher() {\n    const [data, setData] = useState(null);\n\n    useEffect(() => {\n        axios.get('/api/your-endpoint')\n            .then(response => {\n                setData(response.data);\n            })\n            .catch(error => {\n                console.error('Error fetching data: ', error);\n            });\n    }, []);\n\n    return (\n        <div>\n            {data ? JSON.stringify(data) : 'Loading...'}\n        </div>\n    );\n}\n\nexport default DataFetcher;