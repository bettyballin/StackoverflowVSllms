<script type="text/javascript">\n$(document).ready(function(){\n    var attributeid = <?php echo json_encode($r['Attribute']['id']); ?>;\n    var fieldname = <?php echo json_encode($r['Attribute']['label']); ?>;\n\n    $("#" + attributeid).change(function () {\n        alert(fieldname); // This should now show the label correctly\n        alert(attributeid);\n    }); // attribute change\n}); // ready function\n</script>