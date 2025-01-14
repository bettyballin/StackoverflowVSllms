<?php\nsession_start();\n\nif (!isset($_GET["cmd"])) {\n    die("You should have a 'cmd' parameter in your URL");\n}\n$cmd = $_GET["cmd"];\n$pk = isset($_GET["pk"]) ? intval($_GET["pk"]) : die("Invalid or missing 'pk' parameter");\n\n// Database connection\n$con = new mysqli("localhost", "x", "geheim", "ebay");\n\nif ($con->connect_error) {\n    die('Connection failed because of: ' . $con->connect_error);\n}\n\nif ($cmd === "GetAuctionData") {\n    // Prepare and bind\n    $stmt = $con->prepare("SELECT * FROM Auctions WHERE ARTICLE_NO = ?");\n    if ($stmt === false) {\n        die("Prepare statement error: " . $con->error);\n    }\n    $stmt->bind_param("i", $pk);\n\n    // Execute the statement\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    while ($row = $result->fetch_assoc()) {\n        $stmt2 = $con->prepare("SELECT ARTICLE_DESC FROM Auctions WHERE ARTICLE_NO = ?");\n        if (!$stmt2) {\n            die("Prepare statement error: " . $con->error);\n        }\n        $stmt2->bind_param("i", $pk);\n        $stmt2->execute();\n        $row2 = $stmt2->get_result()->fetch_assoc();\n\n        echo "<div id='leftlayer'>\n              <strong>Article Number</strong> {$row['ARTICLE_NO']}<br>\n              <p><strong>Article Name</strong></p> {$row['ARTICLE_NAME']}<br>\n              <p><strong>Subtitle</strong></p> {$row['SUBTITLE']}<br>\n              <p><strong>Username</strong></p> {$row['USERNAME']}<br>\n              <p><strong>Total Selling</strong></p> {$row['QUANT_TOTAL']}<br>\n              <p><strong>Total Sold</strong></p> {$row['QUANT_SOLD']}<br>\n              <p><strong>Highest Bidder</strong></p> {$row['BEST_BIDDER_ID']}<br>\n             </div>";\n\n        echo "<div class='leftlayer2'>\n              <strong>Current Bid</strong> {$row['CURRENT_BID']}<br>\n              <p><strong>Start Price</strong></p> {$row['START_PRICE']}<br>\n              <p><strong>Buyitnow Price</strong></p> {$row['BUYITNOW_PRICE']}<br>\n              <p><strong>Bid Count</strong></p> {$row['BID_COUNT']}<br>\n              <p><strong>Start Date</strong></p> {$row['ACCESSSTARTS']}<br>\n              <p><strong>End Date</strong></p> {$row['ACCESSENDS']}<br>\n              <p><strong>Original End</strong></p> {$row['ACCESSORIGIN_END']}<br>\n              <p><strong>Auction Type</strong></p> {$row['AUCTION_TYPE']}<br>\n             </div>";\n\n        echo "<div class='leftlayer2'>\n              <p><strong>Private Auction</strong></p> {$row['PRIVATE_AUCTION']}<br>\n              <p><strong>Paypal Accepted</strong></p> {$row['PAYPAL_ACCEPT']}<br>\n              <p><strong>Auction Watched</strong></p> {$row['WATCH']}<br>\n              <p><strong>Finished</strong></p> {$row['FINISHED']}<br>\n              <p><strong>Location</strong></p> {$row['LOCATION']}<br>\n              <p><strong>Conditions</strong></p> {$row['CONDITIONS']}<br>\n             </div>";\n\n        echo "<div class='leftlayer2'>\n              <p><strong>Private Auction</strong></p> {$row['PRIVATE_AUCTION']}<br>\n              <p><strong>Auction Details</strong></p>\n                  <a href='#' onclick='showDescription(this); return false;' data-desc='{$row2['ARTICLE_DESC']}'>Show Description</a>\n             </div>";\n\n        echo "<div id='description-{$pk}' style='display:none;'>{$row2['ARTICLE_DESC']}</div>";\n\n        $lastRow = $row;\n    }\n\n    // Close the statement\n    $stmt->close();\n    $stmt2->close();\n}\n\n// Close the database connection\n$con->close();\n\n?>\n<script>\nfunction showDescription(link) {\n    const desc = link.getAttribute('data-desc');\n    document.getElementById(`description-<?= htmlspecialchars($lastRow['ARTICLE_NO']) ?>`).innerHTML = desc;\n    document.getElementById(`description-<?= htmlspecialchars($lastRow['ARTICLE_NO']) ?>`).style.display = 'block';\n}\n</script>