<script type="text/javascript">\n    // This function is called automatically when the page loads and also on partial postbacks.\n    function pageLoad(sender, args) {\n        if (args.get_isPartialLoad()) {\n            // Your jQuery code here. For example, to add a click event handler after content update:\n            $("#<%=GridView1.ClientID %> tr").on("click", function() {\n                alert('Row clicked');\n            });\n        } else {\n            // Full page load initialization\n        }\n    }\n</script>