package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import org.springframework.stereotype.Service;
import com.soen342.demo.IdentityClasses.OfferingIdentity;
import com.soen342.demo.MapperClasses.OfferingMapper;
import com.soen342.demo.RepositoryClasses.OfferingRepository;
import com.soen342.demo.dto.OfferingDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OfferingServiceImpl implements OfferingService {

    private final OfferingRepository offeringRepository;

    @Override
    public OfferingDto createOffering(OfferingDto offeringDto) {
        OfferingIdentity offering = OfferingMapper.mapToOfferingIdentity(offeringDto);
        OfferingIdentity savedOffering = offeringRepository.save(offering);
        return OfferingMapper.mapToOfferingDto(savedOffering);
    }

    @Override
    public OfferingDto getOfferingById(int id) {
        OfferingIdentity offering = offeringRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Offering not found with ID: " + id));
        return OfferingMapper.mapToOfferingDto(offering);
    }

    @Override
    public List<OfferingDto> getAllOfferings() {
        return offeringRepository.findAll()
                .stream()
                .map(OfferingMapper::mapToOfferingDto)
                .toList();
    }
}
