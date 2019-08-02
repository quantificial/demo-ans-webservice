package demo.ans.webservice.database.model.oracle;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyXMasterRepository extends JpaRepository<PolicyXMaster, Integer>{

	public Optional<PolicyXMaster> findByPolicyNumber(String policyNumber);
}
