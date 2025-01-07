package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SangpumRepository extends JpaRepository<Sangpum, Integer>{

    void removeByCode(int code);
}
