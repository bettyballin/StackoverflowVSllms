<?php\n    header('Content-Type: application/json');\n    $USERNAME = '';   //database username\n    $PASSWORD = '';    //database password\n    $DATABASE = '';   //database name\n    $URL = '';        //database location\n\n    $response = ['success' => false, 'data' => [], 'error' => ''];\n\n    if(isset($_GET['getTutorials'])) {\n        $conn = mysqli_connect($URL, $USERNAME, $PASSWORD, $DATABASE);\n        if (!$conn) {\n            $response['error'] = 'Cannot connect to database.';\n            echo json_encode($response);\n            exit;\n        }\n\n        $query = 'SELECT * FROM Tutorials';\n        $result = mysqli_query($conn, $query);\n\n        if ($result && mysqli_num_rows($result) > 0) {\n            while($row = mysqli_fetch_assoc($result)) {\n                $response['data'][] = $row;\n            }\n        } else {\n            $response['error'] = 'No data found or query failed.';\n        }\n\n        mysqli_close($conn);\n    } elseif(isset($_GET['setTutorials'])) {\n        if (isset($_GET['jsonSendData'])) {\n            $jsonString = urldecode($_GET['jsonSendData']);\n            $data = json_decode($jsonString, true);\n\n            $conn = mysqli_connect($URL, $USERNAME, $PASSWORD, $DATABASE);\n            if (!$conn) {\n                $response['error'] = 'Cannot connect to database.';\n                echo json_encode($response);\n                exit;\n            }\n\n            foreach ($data as $tutorialEntry) {\n                $rating = mysqli_real_escape_string($conn, $tutorialEntry['rating']);\n                $id = mysqli_real_escape_string($conn, $tutorialEntry['id']);\n\n                $query = sprintf('UPDATE Tutorials SET rating = "%s" WHERE id = "%s"', $rating, $id);\n                if (!mysqli_query($conn, $query)) {\n                    $response['error'] = mysqli_error($conn);\n                    break;\n                }\n            }\n\n            mysqli_close($conn);\n\n            if (empty($response['error'])) {\n                $response['success'] = true;\n                $response['data'] = 'database updated';\n            }\n        } else {\n            $response['error'] = 'No data sent.';\n        }\n    } else {\n        $response['error'] = 'Unknown request type.';\n    }\n\n    echo json_encode($response);\n    ?>