import React from 'react';\nimport Document, { Html, Head, Main, NextScript } from 'next/document';\n\nclass MyDocument extends Document {\n  render() {\n    return (\n      <Html>\n        <Head>\n          <title>My Page</title>\n          <meta name="description" content="My page description" />\n        </Head>\n        <body>\n          <Main />\n          <NextScript />\n        </body>\n      </Html>\n    );\n  }\n}\n\nexport default MyDocument;