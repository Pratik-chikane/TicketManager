package in.ticketmanger.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ticketmanger.Exception.TouristNotFoundException;
import in.ticketmanger.error.ErrorDetails;

@RestControllerAdvice
public class TouristErrorControllerAdvice {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException te) {
		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), te.getMessage(), "404");

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e) {
		System.out.println("TouristErrorControllerAdvice.handleAllException()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "505");

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);

	}

}
