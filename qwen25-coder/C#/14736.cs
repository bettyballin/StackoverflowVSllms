// Before refactoring - Large function\nvoid processOrder(Order order) {\n    validateOrder(order);\n    calculateTotal(order);\n    applyDiscounts(order);\n    saveToDatabase(order);\n    sendConfirmationEmail(order);\n}\n\n// After refactoring - Smaller, more focused functions\nvoid processOrder(Order order) {\n    validateOrder(order);\n    double total = calculateTotal(order);\n    total = applyDiscounts(total);\n    OrderRepository.save(order);\n    EmailService.sendConfirmation(order);\n}