$("#some_iframe_id").on('load', function() {\n       var frameDoc = this.contentWindow.document || this.contentDocument;\n       console.log(frameDoc);\n   });