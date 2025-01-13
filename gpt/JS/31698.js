// Create a container element\nconst container = document.createElement('div');\n\n// Attach a shadow root to the container\nconst shadowRoot = container.attachShadow({ mode: 'open' });\n\n// Define your custom styles\nconst style = document.createElement('style');\nstyle.textContent = `\n  /* Your custom CSS here */\n  .my-custom-class {\n    color: blue;\n    background-color: lightgray;\n  }\n`;\n\n// Define your custom HTML content\nconst content = document.createElement('div');\ncontent.classList.add('my-custom-class');\ncontent.innerHTML = `<p>This is my custom content.</p>`;\n\n// Append style and content to the shadow root\nshadowRoot.appendChild(style);\nshadowRoot.appendChild(content);\n\n// Append the container to the body or any other part of the host page\ndocument.body.appendChild(container);