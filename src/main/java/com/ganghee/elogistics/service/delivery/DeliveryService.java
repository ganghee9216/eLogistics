package com.ganghee.elogistics.service.delivery;

import com.ganghee.elogistics.domain.delivery.DeliveryQueryRepository;
import com.ganghee.elogistics.dto.delivery.DeliveryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DeliveryService {

    private final DeliveryQueryRepository queryRepository;

    @Transactional
    public List<DeliveryResponseDto> deliveryList(Long memberId) {
        return queryRepository.findAllDeliveryDesc(memberId).stream()
                .map(DeliveryResponseDto::new)
                .collect(Collectors.toList());
    }
}
