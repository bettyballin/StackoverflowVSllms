// File: application/views/scripts/records/index.phtml\n\n    // Displaying the table\n    echo '<table>';\n    echo '<tr><th>ID</th><th>Name</th><th>Actions</th></tr>';\n    foreach ($this->paginator as $record) {\n        echo '<tr>';\n        echo '<td>' . htmlspecialchars($record->id) . '</td>';\n        echo '<td>' . htmlspecialchars($record->name) . '</td>';\n        echo '<td><a href="/records/edit/id/' . htmlspecialchars($record->id) . '">Edit</a></td>';\n        echo '</tr>';\n    }\n    echo '</table>';\n\n    // Displaying pagination control\n    echo $this->paginationControl($this->paginator, 'Sliding', 'pagination_control.phtml');