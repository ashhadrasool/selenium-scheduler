package kwoter.CollingwoodCourier.repo;

import kwoter.CollingwoodCourier.entity.QuotesQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuotesQueueRepository extends JpaRepository<QuotesQueue, Long> {
    List<QuotesQueue> findAll();
    List<QuotesQueue> findTop5ByStatusOrderById(int status);

}
