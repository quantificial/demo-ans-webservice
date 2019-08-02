package demo.ans.webservice.database.model.h2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="T_POLICY_MASTER")
public class PolicyMaster {
	
	@Id
	@Column(name="UNIQUE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uniqueId;
	
	@Column(name="POLICY_NUMBER")
	private String policyNumber;
	
	@Column(name="OWNER_CLIENT_NUMBER")
	private int ownerClientNumber;
	
	@Column(name="PLAN_CODE")
	private String planCode;
	
}
