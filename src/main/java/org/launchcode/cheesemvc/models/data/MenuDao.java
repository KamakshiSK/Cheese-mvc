package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface MenuDao extends CrudRepository<Menu, Integer> {
}
