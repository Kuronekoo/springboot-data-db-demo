package cn.kuroneko.db.demo.repository;

import cn.kuroneko.db.demo.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupRepsitory extends JpaRepository<Group,Long>, JpaSpecificationExecutor<Group> {
}
