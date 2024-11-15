package com.soen342.demo.ControllerClasses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.soen342.demo.dto.OfferingDto;
import com.soen342.demo.ServiceInterfaces.OfferingService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/offerings")
public class OfferingController {

    private final OfferingService offeringService;

    @PostMapping
    public ResponseEntity<OfferingDto> createOffering(@RequestBody OfferingDto offeringDto) {
        OfferingDto savedOffering = offeringService.createOffering(offeringDto);
        return new ResponseEntity<>(savedOffering, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OfferingDto> getOfferingById(@PathVariable("id") int offeringId) {
        OfferingDto offeringDto = offeringService.getOfferingById(offeringId);
        return new ResponseEntity<>(offeringDto, HttpStatus.OK);
    }
}
