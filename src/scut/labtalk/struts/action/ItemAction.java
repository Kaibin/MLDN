package scut.labtalk.struts.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import scut.labtalk.domain.Item;
import scut.labtalk.domain.Subitem;
import scut.labtalk.manager.ServiceLocator;
import scut.labtalk.service.ItemService;

import com.opensymphony.xwork2.ActionSupport;

public class ItemAction extends ActionSupport implements SessionAware{

	/**
	 * @author kaibin
	 */
	private static final long serialVersionUID = 8201308467727110428L;
	private Log logger = LogFactory.getLog(ItemAction.class);
	
	@Autowired
	private ItemService itemService = ServiceLocator.getServiceLocator().getItemService();
	private List<Item> itemList;
	private HashMap<String,List<Subitem>> itemMap;
	private Map<String,Object> session;
	
	public String selectAllItem() {
		
		String userid = (String) session.get("userid");
		if (userid == null || userid == "") {
			addActionError("userid null");
			return "error";
		}
		System.out.println("*******"+userid);
		logger.info("start to selectall");
	
		// ≤È—Ø–≈œ¢
		try {
			itemList = this.itemService.getAllItem();
			itemMap = new HashMap<String,List<Subitem>>();
			List<Subitem> subitems = new ArrayList<Subitem>();
			for(int i=0;i<itemList.size();i++){
				subitems = itemList.get(i).getSubitems();
				itemMap.put(itemList.get(i).getItemid(), subitems);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("start question.jsp");
		return "question";
	}
	
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public HashMap<String, List<Subitem>> getItemMap() {
		return itemMap;
	}

	public void setItemMap(HashMap<String, List<Subitem>> itemMap) {
		this.itemMap = itemMap;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
}
