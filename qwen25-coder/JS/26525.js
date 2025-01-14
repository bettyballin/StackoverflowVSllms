const ajaxLibraries = [\n  {\n    name: "jQuery",\n    learningCurve: "Easy",\n    features: ["Graphics via plugins", "DragDrop", "UI Components"],\n    communitySupport: "High",\n    performance: "Excellent",\n    popularity: "Very High"\n  },\n  {\n    name: "Dojo Toolkit",\n    learningCurve: "Moderate to High",\n    features: ["Build-in Graphics", "Advanced DragDrop", "Extensive UI"],\n    communitySupport: "Moderate",\n    performance: "Good",\n    popularity: "Moderate"\n  },\n  {\n    name: "Ext JS",\n    learningCurve: "High",\n    features: ["UI-based Graphics", "DragDrop", "Powerful Components"],\n    communitySupport: "High",\n    performance: "Very Good",\n    popularity: "High"\n  },\n  {\n    name: "Rico",\n    learningCurve: "Moderate",\n    features: ["Simple AJAX Applications"],\n    communitySupport: "Low",\n    performance: "Good",\n    popularity: "Low"\n  },\n  {\n    name: "Scriptaculous",\n    learningCurve: "Moderate",\n    features: ["Effects and Animations", "DragDrop"],\n    communitySupport: "High",\n    performance: "Good",\n    popularity: "Moderate"\n  },\n  {\n    name: "MooTools",\n    learningCurve: "Moderate to High",\n    features: ["Flexibility", "Performance Optimization", "Customizable Components"],\n    communitySupport: "Moderate",\n    performance: "Excellent",\n    popularity: "High"\n  }\n];\n\n// Example function to evaluate libraries based on specific needs\nfunction recommendLibrary(needs) {\n  return ajaxLibraries.filter(lib => \n    lib.features.includes(needs.graphics) && \n    includes(lib.features, 'DragDrop')\n  );\n}\n\n// Usage\nconsole.log(recommendLibrary({graphics: "Graphics via plugins"}));