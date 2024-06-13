package kwoter.CollingwoodCourier.repo;

import kwoter.CollingwoodCourier.entity.Quotes;
import kwoter.CollingwoodCourier.entity.QuotesQueue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuotesRepository extends JpaRepository<Quotes, Integer> {
    List<Quotes> findAll();
    Optional<Quotes> findById(Integer id);
    Optional<Quotes> findByRequestId(Integer id);
}
