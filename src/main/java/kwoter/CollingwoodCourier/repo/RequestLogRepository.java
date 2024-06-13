package kwoter.CollingwoodCourier.repo;

import kwoter.CollingwoodCourier.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Integer> {
    // You can define custom query methods here if needed


}
