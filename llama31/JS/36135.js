// Using WalkMe\nconst walkthrough = new WalkMe({\n  steps: [\n    {\n      title: 'Step 1',\n      text: 'Click the button to start the process.',\n      action: {\n        type: 'click',\n        selector: '#myButton'\n      }\n    },\n    {\n      title: 'Step 2',\n      text: 'Fill out the form.',\n      action: {\n        type: 'fill',\n        selector: '#myForm input'\n      }\n    }\n  ]\n});