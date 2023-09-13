package kodlama.io.rentACar2.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar2.business.abstracts.BrandService;
import kodlama.io.rentACar2.business.request.CreateBrandRequest;
import kodlama.io.rentACar2.business.request.UpdateBrandRequest;
import kodlama.io.rentACar2.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar2.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar2.business.rules.BrandBusinessRules;
import kodlama.io.rentACar2.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar2.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar2.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands= brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse= brands
				.stream()
				.map(brand-> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand= this.modelMapperService
				.forRequest()
				.map(createBrandRequest, Brand.class);
		
		
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand= this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response=
				this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand= this.modelMapperService.forRequest()
				.map(updateBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
		
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

}
