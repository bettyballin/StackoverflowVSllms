if (isset($_POST['remove'])) {\n        $id = intval($_POST['id']);\n        $sql = "DELETE FROM your_table WHERE id=$id";\n\n        if ($conn->query($sql) === TRUE) {\n            echo "Record deleted successfully";\n        } else {\n            echo "Error deleting record: " . $conn->error;\n        }\n    }