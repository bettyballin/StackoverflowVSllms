var $pager = $('<ul>');\nfor (var i = 1; i <= 5; i++) {\n    var $item = $('<li>');\n    $item.append($('<a>').attr('href', '#').text('Page ' + i));\n    $item.append($('<span>').text('Page ' + i));\n    $pager.append($item);\n}\n$('#container').append($pager);