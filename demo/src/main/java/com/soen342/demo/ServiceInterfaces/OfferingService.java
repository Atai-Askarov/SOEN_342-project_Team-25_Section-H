package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.OfferingDto;

public interface OfferingService {
    OfferingDto createOffering(OfferingDto offeringDto);
    OfferingDto getOfferingById(int id);
    List<OfferingDto> getAllOfferings();
    void deleteOffering(int offeringId);
}
