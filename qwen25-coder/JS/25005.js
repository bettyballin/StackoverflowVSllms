function showModalPopup() {\n       // Example of using jQuery and AJAX\n       $.ajax({\n           url: 'YourPage.aspx/GetDataForModal',\n           type: 'POST',\n           contentType: 'application/json; charset=utf-8',\n           data: JSON.stringify({ param1: value1 }),\n           dataType: 'json',\n           success: function (response) {\n               // Populate Modal content and show it\n               $('#modalContent').html(response.d);\n               $find('ModalPopupExtender1').show();\n           },\n           error: function (error) {\n               console.log(error);\n           }\n       });\n   }