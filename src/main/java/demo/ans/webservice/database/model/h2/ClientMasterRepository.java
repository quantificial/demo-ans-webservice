package demo.ans.webservice.database.model.h2;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientMasterRepository extends JpaRepository<ClientMaster, Integer>{
	
	public Optional<ClientMaster> findByClientId(int clientId);

}
