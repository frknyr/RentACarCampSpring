package kodlama.io.rentACar2.business.abstracts;

import java.util.List;

import kodlama.io.rentACar2.business.request.CreateBrandRequest;
import kodlama.io.rentACar2.business.request.UpdateBrandRequest;
import kodlama.io.rentACar2.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar2.business.responses.GetByIdBrandResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	
}
