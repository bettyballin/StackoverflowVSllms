// cypress/integration/sample_spec.js\ndescribe('My First Test', () => {\n  it('Visits the app', () => {\n    cy.visit('http://localhost:3000');\n    cy.contains('Welcome');\n  });\n});