import { Selector } from 'testcafe';\n\nfixture `Getting Started`\n    .page `http://devexpress.github.io/testcafe/example`;\n\ntest('My first test', async t => {\n    await t\n        .typeText('#developer-name', 'John Doe')\n        .click('#submit-button')\n        .expect(Selector('#article-header').innerText).eql('Thank you, John Doe!');\n});