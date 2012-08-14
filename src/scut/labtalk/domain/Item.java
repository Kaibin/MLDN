package scut.labtalk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
@XmlRootElement
@Entity
@Table(name="item",catalog="labtalk")
public class Item implements Serializable{
	/**
	 * Auther:kaibin
	 */
	private static final long serialVersionUID = -719838080016767358L;
	private String itemid ;
	private String itemname ;
	private int itemcode ;
	private List<Subitem> subitems = new ArrayList<Subitem>();
	
	public Item() {
		super();
	}
	
	public Item(String itemname, int itemcode) {
		super();
		this.itemname = itemname;
		this.itemcode = itemcode;
	}

	public int getItemcode() {
		return itemcode;
	}
	public void setItemcode(int itemcode) {
		this.itemcode = itemcode;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="itemid",length=32)
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	

	@OneToMany(targetEntity=Subitem.class,cascade = { CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "item")
	// 设置lazy=false,将fetch类型设置成直接获取
	//mappedBy指明关系被维护端
	public List<Subitem> getSubitems() {
		return subitems;
	}
	public void setSubitems(List<Subitem> subitems) {
		this.subitems = subitems;
	}
	
	public void addSubitem(Subitem subitem){
		subitem.setItem(this);
		this.subitems.add(subitem);
	}
	
}
