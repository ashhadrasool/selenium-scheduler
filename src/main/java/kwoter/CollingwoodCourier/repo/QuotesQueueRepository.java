package kwoter.CollingwoodCourier.repo;

import kwoter.CollingwoodCourier.QuotesQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuotesQueueRepository extends JpaRepository<QuotesQueue, Long> {
    List<QuotesQueue> findByStatus(int status);
}
