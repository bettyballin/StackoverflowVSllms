<?php if ($user): ?>\n  Hello, <?= $user->name ?>\n<?php else: ?>\n  Hello, guest\n<?php endif; ?>