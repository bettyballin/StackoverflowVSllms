var $holder = $('<div/>').html(responseHtml);\n$('#coupon').html($('#coupon', $holder).html());\n$('#order-summary').html($('#order-summary', $holder).html());