if (isset($_POST['subcatid']) && is_numeric($_POST['subcatid'])) {\n    $subcatid = (int)$_POST['subcatid'];\n    \n    $stmt = $dbc->prepare("SELECT * FROM xxproduct WHERE xsubcatid = ?");\n    $stmt->execute([$subcatid]);\n    $products = $stmt->fetchAll(PDO::FETCH_ASSOC);\n    \n    // Send result\n    echo '<table cellpadding="0" cellspacing="0" border="0" id="ScrollerTable"><tr>';\n    foreach ($products as $p) {\n        echo '<td>\n                <div style="border:#ccc 2px solid; padding:0px; margin-top:20px; margin-bottom:20px; margin-left:8px; margin-right:8px;" class="Container">\n                    <a href="javascript:void(0)" id="' . htmlspecialchars($p['xproductid'], ENT_QUOTES, 'UTF-8') . '" onclick="get_detail_product(this)">\n                        <img src="imgsize.php?w=100&h=100&img=../uploads/product/' . htmlspecialchars($p['xproductid'], ENT_QUOTES, 'UTF-8') . '/' . htmlspecialchars($p['xproductid'], ENT_QUOTES, 'UTF-8') . '__1.jpg" border="0"/>\n                    </a>\n                    <div style="background-color:#ccc; text-align:center; padding:5px;">' . htmlspecialchars($p['xproductname'], ENT_QUOTES, 'UTF-8') . '</div>\n                </div>\n              </td>';\n    }\n    echo '</tr></table>';\n}