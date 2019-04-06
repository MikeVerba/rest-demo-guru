package com.example.restdemoguru.api.v1.mapper;

import com.example.restdemoguru.api.v1.model.VendorDTO;
import com.example.restdemoguru.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO vendorToVendoDTO(Vendor vendor);

    Vendor vendorDTOToVendor(VendorDTO vendorDTO);

}
