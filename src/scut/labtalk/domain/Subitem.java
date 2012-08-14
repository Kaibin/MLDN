package scut.labtalk.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
@XmlRootElement
@Entity
@Table(name="subitem",catalog="labtalk")
public class Subitem implements Serializable{
	/**
	 * Auther:kaibin
	 */
	private static final long serialVersionUID = 869140106078357077L;
	private String subid ;
	private String subname ;
	private int subcode ;
	private Item item ;
	
	public Subitem() {
		super();
	}
	
	public Subitem(String subname, int subcode) {
		super();
		this.subname = subname;
		this.subcode = subcode;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="subid",length=32)
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER,optional=false)
	@JoinColumn(name="itemid")
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
}
