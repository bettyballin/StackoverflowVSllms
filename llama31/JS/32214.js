const container = document.getElementById('my-container');\nconst shadowRoot = container.attachShadow({ mode: 'closed' });\nshadowRoot.innerHTML = '<style>/* your styles here */</style>';