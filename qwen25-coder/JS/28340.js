<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>\n<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>\n<script type="text/javascript">\n    $(document).ready(function() {\n        // add custom validation methods\n        $.validator.addMethod('phone', function(value, el, params) {\n            return this.optional(el) || /^[0-9,+,(), ,]{1,}(,[0-9]+){0,}$/.test(value);\n        }, 'Please enter a valid phone number');\n\n        $.validator.addMethod('numbers', function(value, el, params) {\n            return this.optional(el) || /^[0-9]+$/.test(value);\n        }, 'Invalid entry. Only Numeric is allowed.');\n\n        $.validator.addMethod('domainurl', function(value, el, params) {\n            return this.optional(el) || /^(http\:\/\/(?:www\.)?[a-zA-Z0-9]+(?:(?:\-|_)[a-zA-Z0-9]+)*(?:\.[a-zA-Z0-9]+(?:(?:\-|_)[a-zA-Z0-9]+)*)*\.[a-zA-Z]{2,4}(?:\/)?)$/.test(value);\n        }, 'Please enter a valid domain url');\n\n        $.validator.addMethod('selectone', function(value, element) {\n            return this.optional(element) || (value.indexOf("none") == -1);\n        }, 'Please select an option.');\n\n        $("#form1").validate({\n            rules: {\n                txt_name: {\n                    required: true,\n                    minlength: 2\n                },\n                txt_cmp: {\n                    required: true,\n                    minlength: 2\n                },\n                txt_tel1: {\n                    phone: true,\n                    required: true,\n                    minlength: 3\n                },\n                txt_tel2: {\n                    phone: true,\n                    required: false,\n                    minlength: 3\n                },\n                txt_mob: {\n                    phone: true,\n                    required: false,\n                    minlength: 9\n                },\n                txt_email: {\n                    required: true,\n                    email: true\n                },\n                txt_domname: {\n                    required: true,\n                    domainurl: true\n                },\n                radiobt_domain: "required",\n                ddl_yremail: {\n                    required: true,\n                    selectone: true\n                },\n                ddl_email: {\n                    required: true,\n                    selectone: true\n                },\n                txt_space: {\n                    required: true,\n                    numbers: true\n                },\n                txt_calfr: {\n                    required: true\n                },\n                txt_calto: {\n                    required: true\n                }\n            },\n            messages: {\n                txt_name: "Please enter your name",\n                txt_cmp: "Please enter your company name",\n                radiobt_domain: "Select the Hosting Type"\n            },\n            submitHandler: function(form) {\n                form.submit();\n            }\n        });\n    });\n</script>