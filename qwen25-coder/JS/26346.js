// Assume 'draftCondition' is a global variable or passed parameter that controls when to show DRAFT\nif (reports.getParameterValue("draftCondition") == true) {\n    this.getStyle().backgroundImage = "url('/path/to/draft-image.png')";\n    // Or for plain text as background\n    this.getStyle().backgroundColor = "rgba(255, 0, 0, 0.1)";\n    this.getStyle().color = 'red';\n    this.text = "DRAFT";\n}