package iss.repository;

import iss.entity.Securities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SecuritiesRepository extends JpaRepository<Securities, String>, JpaSpecificationExecutor<Securities> {
}
