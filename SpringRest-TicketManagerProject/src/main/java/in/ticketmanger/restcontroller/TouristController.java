package in.ticketmanger.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ticketmanger.model.Tourist;
import in.ticketmanger.service.ITicketManagerService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
	@Autowired
	private ITicketManagerService service;

	@PostMapping("/save")
	public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist) {
		System.out.println(tourist);
		String msg = service.registerTourist(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	@ApiOperation("Will List All Tourist")
	public ResponseEntity<?> listAllTourist() {
		List<Tourist> list = service.findAll();
		return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> listTouristByID(@PathVariable Integer id) {
		Tourist tourist = service.findById(id);
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {

		String msg = service.updateTourist(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@PatchMapping("/hike/{id}/{hike}")
	public ResponseEntity<String> updatebudget(@PathVariable("id") Integer id, @PathVariable("hike") Float hike) {
		String msg = service.updateTouristById(id, hike);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTrourist(@PathVariable Integer id) {
		String msg = service.deleteTouristById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
