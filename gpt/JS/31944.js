describe('My First Test', () => {\n  it('Visits the Kitchen Sink', () => {\n    cy.visit('https://example.cypress.io')\n    cy.contains('type').click()\n    cy.url().should('include', '/commands/actions')\n    cy.get('.action-email').type('fake@email.com')\n    cy.get('.action-form').submit()\n    cy.contains('Your form has been submitted!')\n  })\n})