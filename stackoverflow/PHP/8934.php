$c = new Criteria();\n$c2 = $c->getNewCriterion(HomeModelPeer::PRICE,\n    $request->getPostParameter('price_from'),\n    Criteria::GREATER_EQUAL);\n$c2->addAnd($c->getNewCriterion(HomeModelPeer::PRICE,\n    $request->getPostParameter('price_to'),\n    Criteria::LESS_EQUAL)\n    );\n$c->add($c2);