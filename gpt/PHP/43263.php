<?php\nsession_start();\n\n$errors = [];\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Validate form data\n    if (empty($_POST['item'])) {\n        $errors['item'] = 'Item is required';\n    }\n    // Add more validation as needed\n\n    if (empty($errors)) {\n        // Save POST data to SESSION\n        $_SESSION['formData'] = $_POST;\n\n        // Redirect to check.php\n        header('Location: check.php');\n        exit;\n    }\n}\n?>\n\n<!DOCTYPE html>\n<html>\n<head>\n    <title>Buy</title>\n</head>\n<body>\n    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">\n        Item: <input type="text" name="item" value="<?php echo isset($_POST['item']) ? htmlspecialchars($_POST['item']) : ''; ?>">\n        <?php if (isset($errors['item'])) echo $errors['item']; ?>\n        <br>\n        Quantity: <input type="number" name="quantity" value="<?php echo isset($_POST['quantity']) ? htmlspecialchars($_POST['quantity']) : ''; ?>">\n        <br>\n        <input type="submit" value="Submit">\n    </form>\n</body>\n</html>