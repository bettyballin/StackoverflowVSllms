<script type="text/javascript">\n        document.observe('dom:loaded', function() {\n            var section = '<%= j @scroll_to_section %>';\n            if (section) {\n                var element = $(section);\n                if (element) {\n                    element.scrollIntoView();\n                }\n            }\n        });\n    </script>