package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.OfferingIdentity;
import com.soen342.demo.dto.OfferingDto;

public class OfferingMapper {

    public static OfferingDto mapToOfferingDto(OfferingIdentity offering) {
        return new OfferingDto(
            offering.getOfferingId(),
            offering.getLessonId(),
            offering.getInstructorId()
        );
    }

    public static OfferingIdentity mapToOfferingIdentity(OfferingDto offeringDto) {
        return new OfferingIdentity(
            offeringDto.getOfferingId(),
            offeringDto.getLessonId(),
            offeringDto.getInstructorId()
        );
    }
}
