class PubSub {\n    constructor() {\n        this.events = {};\n    }\n\n    subscribe(event, listener) {\n        if (!this.events[event]) {\n            this.events[event] = [];\n        }\n        this.events[event].push(listener);\n    }\n\n    publish(event, data) {\n        if (this.events[event]) {\n            this.events[event].forEach(listener => listener(data));\n        }\n    }\n}\n\n// Example Usage\nconst pubSub = new PubSub();\n\n// Subscribe listeners\npubSub.subscribe('ajaxComplete', (data) => {\n    console.log('Listener 1 received data:', data);\n    // Update UI part 1\n});\n\npubSub.subscribe('ajaxComplete', (data) => {\n    console.log('Listener 2 received data:', data);\n    // Update UI part 2\n});\n\n// Simulate an AJAX call\nfunction ajaxCall() {\n    setTimeout(() => {\n        const responseData = { key: 'value' }; // Sample response data\n        pubSub.publish('ajaxComplete', responseData);\n    }, 1000);\n}\n\n// Trigger the AJAX call\najaxCall();