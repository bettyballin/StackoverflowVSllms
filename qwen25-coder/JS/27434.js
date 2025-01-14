// Create a new element\nconst container = document.createElement('div');\ndocument.body.appendChild(container);\n\n// Attach a Shadow DOM tree to this element (open mode)\nconst shadowRoot = container.attachShadow({ mode: 'open' });\n\n// Inject your custom HTML and CSS into the shadow root\nshadowRoot.innerHTML = `\n  <style>\n    /* Your styles here */\n    p {\n      color: blue;\n      font-size: 16px;\n    }\n    div {\n      background-color: yellow;\n      padding: 20px;\n    }\n  </style>\n  <div>\n    <p>This text is styled with your CSS, not the host page's.</p>\n  </div>\n`;