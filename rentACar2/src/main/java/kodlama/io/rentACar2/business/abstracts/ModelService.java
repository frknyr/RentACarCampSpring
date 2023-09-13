package kodlama.io.rentACar2.business.abstracts;

import java.util.List;

import kodlama.io.rentACar2.business.request.CreateModelRequest;
import kodlama.io.rentACar2.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
