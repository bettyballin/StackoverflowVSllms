// Conditionally set a background image\nif (reports.getParameterValue("draftCondition") == true) {\n    this.getStyle().backgroundImage = "url('/path/to/draft-image.png')";\n    this.getStyle().backgroundRepeat = "no-repeat";\n    this.getStyle().backgroundSize = "cover"; // Adjust size as needed\n}