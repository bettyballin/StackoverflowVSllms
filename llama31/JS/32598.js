import { AbortController } from 'abort-controller';\n\nconst controllers = [];\n\n// Create a new AbortController for each request\nfunction makeRequest(url) {\n  const controller = new AbortController();\n  controllers.push(controller);\n  fetch(url, { signal: controller.signal });\n}\n\n// Cancel all requests\nfunction cancelAllRequests() {\n  controllers.forEach((controller) => controller.abort());\n}