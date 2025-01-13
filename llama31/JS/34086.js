jQuery.fn.tablerize = function() {\n    return this.each(function() {\n        var table;\n        $(this).find('li').each(function(i) {\n            var values = $(this).html().split('*');\n            if(i == 0) {\n                table = $('<table>');\n                var thead = $('<thead>');\n                $.each(values, function(y) {\n                    thead.append($('<tr>').append($('<th>').html(values[y])));\n                });\n                table.append(thead);\n            } else {\n               var tr = $('<tr>');\n               $.each(values, function(y) {\n                   tr.append($('<td>').html(values[y]));\n               });\n               table.append(tr);\n            }\n        });\n        $(this).after(table).remove();\n    });\n};