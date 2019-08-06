package demo.ans.webservice.database.model.oracle;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OraclePolicyMasterRepository extends JpaRepository<OraclePolicyMaster, Integer>{

	public Optional<OraclePolicyMaster> findByPolicyNumber(String policyNumber);
}
