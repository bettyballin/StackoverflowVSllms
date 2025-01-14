$sql = "\n    SELECT a.code, a.ad_id, a.position, a.type, a.image, a.url, a.height, a.width\n    FROM " . AD_TABLE . " a\n    JOIN " . USER_GROUP_TABLE . " g ON g.group_id IN (a.groups)\n    WHERE (a.max_views >= a.views OR a.max_views = '0')\n    AND (FIND_IN_SET(" . $forum_id . ", a.show_forums) > 0 OR a.show_all_forums = '1')\n    AND g.user_id = " . (int)$user->data['user_id'] . "\n    AND FIND_IN_SET(" . $user->data['user_rank'] . ", a.ranks)\n    AND a.start_time < UNIX_TIMESTAMP()\n    AND a.end_time > UNIX_TIMESTAMP()\n    AND (a.clicks <= a.max_clicks OR a.max_clicks = '0')\n";