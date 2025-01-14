<?php\n// Example arrays\n$names = ["Alice", "Bob", "Charlie"];\n$imageUrls = ["image1.jpg", "image2.jpg", "image3.jpg"];\n\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    $selectedNames = [];\n    $selectedImages = [];\n\n    foreach ($names as $index => $name) {\n        if (isset($_POST["check_$index"])) {\n            $selectedNames[] = $names[$index];\n            $selectedImages[] = $imageUrls[$index];\n        }\n    }\n\n    echo "Selected Names: ";\n    print_r($selectedNames);\n    echo "\n";\n    echo "Selected Images: ";\n    print_r($selectedImages);\n}\n?>\n\n<form method="post" action="">\n    <?php foreach ($names as $index => $name): ?>\n        <div>\n            <!-- Display name and image -->\n            <label><?php echo htmlspecialchars($name); ?></label>\n            <img src="<?php echo htmlspecialchars($imageUrls[$index]); ?>" alt="Image for <?php echo htmlspecialchars($name); ?>">\n            \n            <!-- Checkbox with default checked attribute -->\n            <input type="checkbox" name="check_<?php echo $index; ?>" value="1" checked>\n        </div>\n    <?php endforeach; ?>\n    <button type="submit">Submit</button>\n</form>