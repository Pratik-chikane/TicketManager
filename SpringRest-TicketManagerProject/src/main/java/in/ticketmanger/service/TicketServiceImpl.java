package in.ticketmanger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ticketmanger.Exception.TouristNotFoundException;
import in.ticketmanger.model.Tourist;
import in.ticketmanger.repository.ITicketManagerRepo;

@Service
public class TicketServiceImpl implements ITicketManagerService {
	@Autowired
	private ITicketManagerRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		// TODO Auto-generated method stub
		Integer tid = repo.save(tourist).getTid();
		return "Tourist Registered with id"+tid;
	}

	@Override
	public List<Tourist> findAll()  {
		
		List<Tourist> list = repo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
		
	}

	@Override
	public Tourist findById(Integer id) {
		
		
//		Optional<Tourist> optional = repo.findById(id);
//		if (optional.isPresent()) {
//			return optional.get();
//		}else {
//			throw new TouristNotFoundException("Tourist Not found with id"+id);
//		}
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist Not found with id"+id));
	}

	@Override
	public String updateTourist(Tourist tourist) {
		Optional<Tourist> optional = repo.findById(tourist.getTid());
		if (optional.isPresent()) {
			Tourist tourist2 = repo.save(tourist);
			return "Record updated with id "+tourist.getTid();
		}else {
			throw new TouristNotFoundException("Tourist not found ");
		}
	}

	@Override
	public String updateTouristById(Integer id, Float hike) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hike/100)));
			repo.save(tourist);
			return "Tourist Budget is updated"; 
		}else {
			throw new TouristNotFoundException("Tourist not found with id "+id);
		}
	}

	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()) {
			repo.deleteById(id);
			return "Tourist is deleted with id "+id;
		}else {
			throw new TouristNotFoundException("Tourist not found with id "+id);
		}
	}

}
