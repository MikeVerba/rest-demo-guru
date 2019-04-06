package com.example.restdemoguru.services;

import com.example.restdemoguru.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorById(Long id,VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id,VendorDTO vendorDTO);

    void deleteVendor(Long id);






}
