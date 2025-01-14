try {\n    $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    $stmt = $pdo->prepare("SELECT ss.*, se.name AS engine,\n                                 ss.last_run_at + INTERVAL ss.refresh_frequency DAY AS next_run_at,\n                                 se.logo_name\n                            FROM searches ss \n                            JOIN search_engines se ON ss.engine_id = se.id\n                            WHERE ss.user_id = ?\n                            GROUP BY ss.id\n                            ORDER BY ss.project_id, ss.domain, ss.keywords");\n\n    $stmt->execute([$user_id]);\n\n    $results = $stmt->fetchAll(PDO::FETCH_ASSOC);\n} catch (PDOException $e) {\n    error_log('Connection failed: ' . $e->getMessage());\n}