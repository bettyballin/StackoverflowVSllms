<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>\n\n<script type="text/javascript">\n    $(document).ready(function(){\n        loadGridViewData(2, '#GridView2');\n        loadGridViewData(3, '#GridView3');\n        loadGridViewData(4, '#GridView4');\n    });\n\n    function loadGridViewData(gridViewNumber, gridViewSelector) {\n        $.ajax({\n            type: "POST",\n            url: "YourPage.aspx/GetGridViewData",\n            data: JSON.stringify({ gridViewNumber: gridViewNumber }),\n            contentType: "application/json; charset=utf-8",\n            dataType: "json",\n            success: function(response) {\n                var data = JSON.parse(response.d);\n\n                var html = '<table>';\n                // Assuming your DataTable has columns "Column1", "Column2", etc.\n                for (var i = 0; i < data.length; i++) {\n                    html += '<tr>';\n                    html += '<td>' + data[i].Column1 + '</td>';\n                    html += '<td>' + data[i].Column2 + '</td>';\n                    // Add more columns as needed\n                    html += '</tr>';\n                }\n                html += '</table>';\n\n                $(gridViewSelector).html(html);\n            },\n            error: function(error) {\n                console.log("Error: " + error);\n            }\n        });\n    }\n</script>