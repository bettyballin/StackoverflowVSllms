function has_voted($user) {\n    try {\n        $db = parent::getConnection();\n        $stmt = $db->prepare("SELECT id FROM votes WHERE username = ? AND article_id = ?");\n        $stmt->bind_param("si", $user, $this->id);\n        $stmt->execute();\n        $result = $stmt->get_result();\n        if ($result->num_rows === 1) {\n            return true;\n        } else {\n            return false;\n        }\n    } catch (Exception $e) {\n        throw $e;\n    } finally {\n        parent::closeConnection($db);\n    }\n}