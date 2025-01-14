<?php\n// Assuming $pdo is your database connection and already established\n\n// ID of the volunteer you want to edit (in this case, 7)\n$volunteer_id = 7;\n\n// Get all venues from the venues table\n$query_venues = "SELECT id, venue_name FROM venues";\n$stmt_venues = $pdo->query($query_venues);\n$venues = $stmt_venues->fetchAll(PDO::FETCH_ASSOC);\n\n// Get the current venue of the volunteer with id=7\n$query_volunteer = "SELECT volunteers_2009.id AS volunteer_id, volunteers_2009.venue_id, venues.venue_name \n                    FROM volunteers_2009 \n                    LEFT JOIN venues ON volunteers_2009.venue_id = venues.id \n                    WHERE volunteers_2009.id = :volunteer_id";\n$stmt_volunteer = $pdo->prepare($query_volunteer);\n$stmt_volunteer->execute([':volunteer_id' => $volunteer_id]);\n$volunteer_info = $stmt_volunteer->fetch(PDO::FETCH_ASSOC);\n\n$current_venue_id = $volunteer_info['venue_id'];\n?>\n\n<form action="upd.php?id=<?= htmlspecialchars($volunteer_id) ?>" method="post">\n    <select name="venue_id">\n        <?php foreach ($venues as $venue): ?>\n            <option value="<?= htmlspecialchars($venue['id']) ?>" \n                    <?= ($current_venue_id == $venue['id'] ? 'selected' : '') ?>>\n                <?= htmlspecialchars($venue['venue_name']) ?>\n            </option>\n        <?php endforeach; ?>\n    </select>\n    <input type="submit" value="Submit" name="submit">\n</form>