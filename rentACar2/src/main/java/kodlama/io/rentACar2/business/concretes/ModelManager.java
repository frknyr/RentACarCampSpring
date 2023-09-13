package kodlama.io.rentACar2.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import kodlama.io.rentACar2.business.abstracts.ModelService;
import kodlama.io.rentACar2.business.request.CreateModelRequest;
import kodlama.io.rentACar2.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar2.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar2.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar2.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models= this.modelRepository.findAll();
		
		List<GetAllModelsResponse> getAll= models.stream()
				.map(model-> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		
		return getAll;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model= this.modelMapperService.forRequest()
				.map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}
	
}
