package kwoter.CollingwoodCourier.repo;

import kwoter.CollingwoodCourier.entity.QuotesQueue;
import kwoter.CollingwoodCourier.entity.RequestLogData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequestLogDataRepository extends JpaRepository<RequestLogData, Integer> {

    Optional<RequestLogData> findByRequestLogId(Integer id);
}
