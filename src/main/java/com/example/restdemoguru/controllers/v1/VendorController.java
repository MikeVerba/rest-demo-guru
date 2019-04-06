package com.example.restdemoguru.controllers.v1;


import com.example.restdemoguru.api.v1.model.VendorDTO;
import com.example.restdemoguru.api.v1.model.VendorListDTO;
import com.example.restdemoguru.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/vendors")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }


    @GetMapping
    public ResponseEntity<VendorListDTO> getAllVendors(){

        return new ResponseEntity<VendorListDTO>(new VendorListDTO(vendorService.getAllVendors()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<VendorDTO>getVendorById(@PathVariable Long id){

        return new ResponseEntity<VendorDTO>(vendorService.getVendorById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendorDTO> createVendor(@RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.createNewVendor(vendorDTO),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<VendorDTO> updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){

        return new ResponseEntity<VendorDTO>(vendorService.saveVendorById(id, vendorDTO),HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity<VendorDTO> patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(vendorService.patchVendor(id,vendorDTO),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id){
        vendorService.deleteVendor(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }





}
