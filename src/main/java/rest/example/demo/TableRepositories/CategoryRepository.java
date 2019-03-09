package rest.example.demo.TableRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import rest.example.demo.TableModels.category;
@Repository
public interface CategoryRepository extends JpaRepository<category,Long> {
    category findByCategoryName(String category);

}
