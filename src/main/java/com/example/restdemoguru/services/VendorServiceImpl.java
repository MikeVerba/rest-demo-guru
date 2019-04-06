package com.example.restdemoguru.services;

import com.example.restdemoguru.api.v1.mapper.VendorMapper;
import com.example.restdemoguru.api.v1.model.VendorDTO;
import com.example.restdemoguru.domain.Vendor;
import com.example.restdemoguru.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    private final VendorMapper vendorMapper;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAllVendors() {

        return vendorRepository.findAll()
                .stream()
                .map(vendor->{
                    VendorDTO vendorDTO = vendorMapper.vendorToVendoDTO(vendor);
                    vendorDTO.setVendorUrl("api/v1/vendors/" + vendor.getId());
                    return vendorDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendoDTO(vendor);
                    vendorDTO.setVendorUrl("api/v1/vendors/" + vendor.getId());
                    return vendorDTO;

                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO returnDTO = vendorMapper.vendorToVendoDTO(savedVendor);

        returnDTO.setVendorUrl("api/v1/vendors/" + savedVendor.getId());

        return returnDTO;

    }

    @Override
    public VendorDTO saveVendorById(Long id, VendorDTO vendorDTO) {

        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);

        vendor.setId(id);

        Vendor savedVendor = vendorRepository.save(vendor);

        VendorDTO returnDTO = vendorMapper.vendorToVendoDTO(savedVendor);

        returnDTO.setVendorUrl("api/v1/vendors/" + savedVendor.getId());

        return returnDTO;
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id)
                .map(vendor -> {
                    if(vendorDTO.getName() !=null){
                        vendor.setName(vendorDTO.getName());
                    }

                    VendorDTO returnDTO = vendorMapper.vendorToVendoDTO(vendor);
                    returnDTO.setVendorUrl("api/v1/vendors/" + vendor.getId());
                    return  returnDTO;

                }).orElseThrow(ResourceNotFoundException::new);

    }

    @Override
    public void deleteVendor(Long id) {

        Optional<Vendor> vendorOptional = vendorRepository.findById(id);

        if(vendorOptional.isPresent()){

            vendorRepository.deleteById(id);
        } else throw new ResourceNotFoundException();

    }
}
