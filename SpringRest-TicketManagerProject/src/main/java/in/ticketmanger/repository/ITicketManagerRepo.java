package in.ticketmanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ticketmanger.model.Tourist;
@Repository
public interface ITicketManagerRepo extends JpaRepository<Tourist, Integer> {


}
