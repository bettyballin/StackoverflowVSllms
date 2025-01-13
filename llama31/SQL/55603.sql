WITH results AS (\n    SELECT \n        a.NAME_LAST, \n        a.NAME_FIRST, \n        ca.status, \n        AVG(r.score) AS average_score, \n        COUNT(r.review_id) AS review_count\n    FROM \n        application a\n    INNER JOIN \n        committee_applications ca ON a.application_id = ca.application_id\n    LEFT JOIN \n        reviews r ON a.application_id = r.application_id\n    GROUP BY \n        a.application_id, a.NAME_LAST, a.NAME_FIRST, ca.status\n)\nSELECT * FROM results;