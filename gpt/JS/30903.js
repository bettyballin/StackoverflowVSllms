<script type="text/javascript">\n    function validatePhoneOrEmail(sender, args) {\n        var phoneNumber = document.getElementById('<%= txtPhoneNumber.ClientID %>').value;\n        var emailAddress = document.getElementById('<%= txtEmailAddress.ClientID %>').value;\n\n        if (phoneNumber.trim() === "" && emailAddress.trim() === "") {\n            args.IsValid = false;\n        } else {\n            args.IsValid = true;\n        }\n    }\n</script>