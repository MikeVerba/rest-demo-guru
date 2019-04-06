package com.example.restdemoguru.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class VendorListDTO {

    List<VendorDTO> vendorDTO;

    public VendorListDTO(List<VendorDTO> vendorDTO) {
        this.vendorDTO = vendorDTO;
    }

    public List<VendorDTO> getVendorDTO() {
        return vendorDTO;
    }

    public void setVendorDTO(List<VendorDTO> vendorDTO) {
        this.vendorDTO = vendorDTO;
    }
}
