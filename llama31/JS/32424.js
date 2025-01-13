// Embed the Word document\nconst iframe = document.getElementById('word-iframe');\niframe.src = `https://view.officeapps.live.com/op/embed.aspx?src=${encodeURIComponent('your_word_document_url.docx')}`;\n\n// Remove toolbars\nconst word = new OfficeExtension.Word();\nword.run(async (context) => {\n  context.document.settings.removeToolBar();\n  await context.sync();\n});\n\n// Fill input fields\nword.run(async (context) => {\n  const inputFields = context.document.contentControls;\n  inputFields.items.forEach((field) => {\n    field.insertText('Filled in value', Word.InsertLocation.replace);\n  });\n  await context.sync();\n});\n\n// Print the document\nconst printButton = document.getElementById('print-button');\nprintButton.addEventListener('click', async () => {\n  await word.run(async (context) => {\n    context.document.print();\n    await context.sync();\n  });\n});