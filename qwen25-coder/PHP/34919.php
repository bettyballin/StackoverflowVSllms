$query = PetInfoQuery::create()\n    ->leftJoinLostPet('lp')\n    ->where('PetInfo.AccountId = ?', $user->getProfile()->getAccountId())\n    ->andWhere('LostPet.PetInfoId IS NULL');\n\n$results = $query->find();