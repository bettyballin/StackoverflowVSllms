<?php\n// Assume $formData is an array storing the posted data.\n$formData = $_POST;\n\n// For checkboxes (assuming 'services' is an array as it can handle multiple selections)\n$selectedServices = isset($formData['services']) ? $formData['services'] : [];\n\n// For radio buttons (assuming 'gender' is a string for radio selection)\n$selectedGender = isset($formData['gender']) ? $formData['gender'] : '';\n?>\n<form method="post">\n    <!-- Checkboxes -->\n    Service A: <input type="checkbox" name="services[]" value="A" <?php echo in_array('A', $selectedServices) ? 'checked="checked"' : ''; ?>>\n    Service B: <input type="checkbox" name="services[]" value="B" <?php echo in_array('B', $selectedServices) ? 'checked="checked"' : ''; ?>>\n\n    <!-- Radio Buttons -->\n    Male: <input type="radio" name="gender" value="M" <?php echo $selectedGender === 'M' ? 'checked="checked"' : ''; ?>>\n    Female: <input type="radio" name="gender" value="F" <?php echo $selectedGender === 'F' ? 'checked="checked"' : ''; ?>>\n\n    <!-- Select -->\n    <select name="country">\n        <option value="US" <?php echo isset($formData['country']) && $formData['country'] === 'US' ? 'selected="selected"' : ''; ?>>USA</option>\n        <option value="CA" <?php echo isset($formData['country']) && $formData['country'] === 'CA' ? 'selected="selected"' : ''; ?>>Canada</option>\n    </select>\n\n    <input type="submit" value="Submit">\n    <input type="reset" value="Reset">\n</form>