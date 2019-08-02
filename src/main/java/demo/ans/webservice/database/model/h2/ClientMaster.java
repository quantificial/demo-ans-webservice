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
@Table(name="T_CLIENT_MASTER")
public class ClientMaster {
	
	@Id
	@Column(name="UNIQUE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uniqueId;
	
	@Column(name="CLIENT_ID")
	private int clientId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
}
