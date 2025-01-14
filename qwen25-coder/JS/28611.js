<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>\n<script type="text/javascript">\n    $(document).ready(function () {\n        $('#fileUploadForm').on('submit', function (e) {\n            e.preventDefault(); // Prevent default form submission\n\n            var formData = new FormData(this);\n\n            $.ajax({\n                url: '@Url.Action("UploadFile", "Home")',\n                type: 'POST',\n                data: formData,\n                contentType: false, // Tell jQuery not to set the content-type\n                processData: false, // Tell jQuery not to process the data\n                xhr: function () {\n                    var xhr = new window.XMLHttpRequest();\n                    xhr.upload.addEventListener("progress", function (evt) {\n                        if (evt.lengthComputable) {\n                            var percentComplete = evt.loaded / evt.total;\n                            $('#progressBar').width(percentComplete * 100 + "%");\n                        }\n                    }, false);\n                    return xhr;\n                },\n                success: function (result) {\n                    alert('File uploaded successfully!');\n                },\n                error: function () {\n                    alert('There was an error uploading your file.');\n                }\n            });\n        });\n    });\n</script>