<?php\n\nnamespace Drupal\custom_module\Plugin\rest\resource;\n\nuse Drupal\rest\Plugin\ResourceBase;\nuse Drupal\rest\ResourceResponse;\nuse Symfony\Component\HttpKernel\Exception\HttpException;\nuse Drupal\node\Entity\Node;\n\n/**\n * Provides a Resource to edit nodes.\n *\n * @RestResource(\n *   id = "node_edit",\n *   label = @Translation("Edit Node"),\n *   uri_paths = {\n *     "canonical" = "/api/node/{nid}",\n *     "create" = "/api/node"\n *   }\n * )\n */\nclass NodeEditResource extends ResourceBase {\n\n  /**\n   * {@inheritdoc}\n   */\n  public function patch($nid, $data) {\n    try {\n      $node = Node::load($nid);\n      if ($node) {\n        $node->setTitle($data['title']);\n        // Add more fields as necessary.\n        $node->save();\n        return new ResourceResponse(['message' => 'Node updated successfully']);\n      } else {\n        throw new HttpException(404, 'Node not found');\n      }\n    } catch (\Exception $e) {\n      throw new HttpException(500, $e->getMessage());\n    }\n  }\n\n}