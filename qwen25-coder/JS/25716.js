function do_str_length_test() {\n    sample_field = document.getElementById('sample').value;\n    x_str_length_test(sample_field, do_str_length_test_cb, 'POST'); // Specify method as 'POST'\n}