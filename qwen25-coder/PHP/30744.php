foreach ($contents as $content) {\n    ?>\n    <tr>\n        <td><?php echo esc_html($content->name); ?></td>\n        <td><?php echo esc_html($content->remaining); ?></td>\n        <td><?php echo esc_html($content->contract_value); ?></td>\n        <td><?php echo esc_html($content->provision_ids); ?></td>\n    </tr>\n<?php \n}