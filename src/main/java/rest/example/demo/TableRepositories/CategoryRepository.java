package rest.example.demo.TableRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.example.demo.TableModels.category;

public interface CategoryRepository extends JpaRepository<category,Long> {

}
