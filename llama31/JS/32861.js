// Using Next.js (React)\nimport { render } from 'next';\nimport App from './App';\n\nconst app = render(<App />, { url: '/products' });\nres.send(app.html);