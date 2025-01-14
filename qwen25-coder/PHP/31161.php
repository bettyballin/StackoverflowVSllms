<?php\n// Assuming $id comes from a trusted source or has been sanitized\n$id = 1; // or $id = intval($_POST['id']); after proper validation and sanitization\n\n$safeId = htmlspecialchars($id, ENT_QUOTES, 'UTF-8');\n$url = "my.php?action=show&id=" . urlencode($safeId);\n?>\n\n<a href="<?php echo $url; ?>" onclick="return display(<?php echo $safeId; ?>);">Click</a>