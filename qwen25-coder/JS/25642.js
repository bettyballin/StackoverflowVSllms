function decideDataModel(isInteroperabilityRequired) {\n    if (isInteroperabilityRequired) {\n        return "Use HL7 RIM for broader compatibility and support.";\n    } else {\n        return "Design a custom data model tailored to your specific requirements for simplicity.";\n    }\n}\n\nvar isInteroperabilityRequired = false; // Set this based on your project's needs\nconsole.log(decideDataModel(isInteroperabilityRequired));