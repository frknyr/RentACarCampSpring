package kodlama.io.rentACar2;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.rentACar2.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar2.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACar2.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentACar2Application {

	public static void main(String[] args) {
		SpringApplication.run(RentACar2Application.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails= new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails problemDetails= new ValidationProblemDetails();
		problemDetails.setMessage(methodArgumentNotValidException.getMessage());
		problemDetails.setValidationErrors(new HashMap<String,String>());
		return problemDetails;
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
