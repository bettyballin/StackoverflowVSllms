function RenderTable(data) {\n    // compile template\n    var template = Handlebars.compile($('#table-template').html());\n\n    // render table data\n    $('#table-container').html(template(data));\n}