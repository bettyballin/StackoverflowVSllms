// Using Shepherd.js\nconst tour = new Shepherd.Tour({\n  id: 'myTour',\n  steps: [\n    {\n      title: 'Step 1',\n      text: 'Click the button to start the process.',\n      attachTo: {\n        element: '#myButton',\n        on: 'bottom'\n      }\n    },\n    {\n      title: 'Step 2',\n      text: 'Fill out the form.',\n      attachTo: {\n        element: '#myForm',\n        on: 'top'\n      }\n    }\n  ]\n});