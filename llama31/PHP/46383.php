if(isset($_POST['submit'])) {\n    //size condition \n    if ($_FILES['uploaded']['size'] > 350000) {\n        $mesg = "Your file is too large.<br>";\n        exit;\n    }\n\n    if(move_uploaded_file($_FILES['uploaded']['tmp_name'], "upload/" . $_FILES['uploaded']['name'])) {\n        $mesg =  "The file ". basename($_FILES['uploaded']['name']). " has been uploaded";   \n    } else {\n        $mesg =  "Sorry, there was a problem uploading your file.";\n    }   \n} else {\n    $mesg = "Select a File to upload.";\n}