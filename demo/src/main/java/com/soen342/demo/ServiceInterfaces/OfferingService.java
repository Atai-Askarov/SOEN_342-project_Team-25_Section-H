package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.OfferingDto;

public interface OfferingService {
    OfferingDto createOffering(OfferingDto offeringDto);
    OfferingDto getOfferingById(int id);
}
