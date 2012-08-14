package scut.labtalk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
@XmlRootElement
@Entity
@Table(name="admin",catalog="labtalk")
public class Admin implements Serializable{
	/**
	 * Auther:kaibin
	 */
	private static final long serialVersionUID = 8675334543214840521L;
	private String id ;
	private String adminid ;
	private String adminpwd ;
	
	public Admin() {
		super();
	}
	public Admin(String adminid, String adminpwd) {
		super();
		this.adminid = adminid;
		this.adminpwd = adminpwd;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="id",length=32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
