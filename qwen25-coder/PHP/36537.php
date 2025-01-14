public function ValidReg() {\n    if (!empty($_POST['username'])\n        && !empty($_POST['password'])\n        && !empty($_POST['email'])\n        && !empty($_POST['state'])) {\n\n        $valid = true;\n\n        $username = $_POST['username'];\n        $password = password_hash($_POST['password'], PASSWORD_BCRYPT);\n        $email = $_POST['email'];\n        $firstname = $_POST['firstname'];\n        $lastname = $_POST['lastname'];\n        $state = $_POST['state'];\n\n        $conn = new mysqli("localhost", "user", "password", "dbname");\n        if ($conn->connect_error) {\n            die("Connection failed: " . $conn->connect_error);\n        }\n\n        // Check for existing username\n        $stmt = $conn->prepare("SELECT * FROM users WHERE Username = ?");\n        $stmt->bind_param("s", $username);\n        $stmt->execute();\n        $result = $stmt->get_result();\n\n        if ($result->num_rows == 1) {\n            echo "<div id='shopperlogin1'><p>Sorry, that username is taken.<br /> Please go back and try again.</p></div>";\n        } else {\n            // Insert into temp_users\n            $confirm_code = bin2hex(random_bytes(32));\n\n            $stmt = $conn->prepare("INSERT INTO temp_users (confirm_code, Username, Password, EmailAddress, FirstName, LastName, State) VALUES (?, ?, ?, ?, ?, ?, ?)");\n            $stmt->bind_param("sssssss", $confirm_code, $username, $password, $email, $firstname, $lastname, $state);\n\n            if ($stmt->execute()) {\n                // Send confirmation email\n                $to = $email;\n                $subject = "Your Confirmation Link";\n                $message = "Your Confirmation link \r\nClick on this link to activate your account \r\nhttp://www.employeediscounted.com/secret/login.php?passkey=$confirm_code";\n                $headers = "From: blahblah@blahbalh.com\r\n";\n\n                if (mail($to, $subject, $message, $headers)) {\n                    echo "<div id='emailmsg'>Your Confirmation link Has Been Sent To Your Email Address.</div>";\n                } else {\n                    echo "<div id='emailmsg'>Cannot send Confirmation link to your e-mail address.</div>";\n                }\n            } else {\n                echo "<div id='emailmsg'>Not found your email in our database.</div>";\n            }\n        }\n\n        $stmt->close();\n        $conn->close();\n\n    } else {\n        $valid = false;\n    }\n    return $valid;\n}