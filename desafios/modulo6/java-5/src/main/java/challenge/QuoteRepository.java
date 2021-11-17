package challenge;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Override
    List<Quote> findAll();

    List<Quote> findByActorEquals(String actor);
}
