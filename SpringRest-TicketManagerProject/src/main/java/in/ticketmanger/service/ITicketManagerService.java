package in.ticketmanger.service;

import java.util.List;

import in.ticketmanger.model.Tourist;

public interface ITicketManagerService {
	
	public String registerTourist(Tourist tourist);
	
	public List<Tourist> findAll();
	
	public Tourist findById(Integer id);
	
	public String updateTourist(Tourist tourist);
	
	public String updateTouristById(Integer id,Float hike);
	
	public String deleteTouristById(Integer id);

}
